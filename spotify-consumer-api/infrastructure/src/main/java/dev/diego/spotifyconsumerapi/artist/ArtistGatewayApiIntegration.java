package dev.diego.spotifyconsumerapi.artist;

import dev.diego.spotifyconsumerapi.Pageable;
import dev.diego.spotifyconsumerapi.Search;
import dev.diego.spotifyconsumerapi.infra.clients.SpotifyArtistSearchClient;
import dev.diego.spotifyconsumerapi.infra.clients.response.ArtistResponse;
import dev.diego.spotifyconsumerapi.infra.clients.response.ExternalUrlResponse;
import dev.diego.spotifyconsumerapi.infra.clients.response.FollowersResponse;
import dev.diego.spotifyconsumerapi.infra.clients.response.ImageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ArtistGatewayApiIntegration implements ArtistGateway {

    private final SpotifyArtistSearchClient client;
    @Override
    public Pageable<Artist> search(final Search search) {

        final var response = client.search(
                search.getArtistName(),
                "artist",
                "BR",
                search.getItemsPerPage(),
                search.getOffset()
        );

        final var artistsResponse = response.artists();

        final var artists = artistsResponse.artists().stream()
                .map(this::mapArtist)
                .toList();

        return Pageable.with(artists, search.getItemsPerPage(), search.getPageNumber(), artistsResponse.total());
    }

    private Artist mapArtist(final ArtistResponse artist) {
        final var followers = extractFollowers(artist);
        final var url = extractUrl(artist);

        final var images = extractImages(artist);

        return Artist.with(
                artist.id(),
                artist.name(),
                followers,
                artist.popularity(),
                artist.deepLink(),
                url,
                artist.genres(),
                images);
    }

    private Set<Image> extractImages(final ArtistResponse artist) {
        return Optional.ofNullable(artist.images())
                .map(this::mapImages)
                .orElse(Collections.emptySet());
    }

    private static String extractUrl(final ArtistResponse artist) {
        return Optional.ofNullable(artist.url())
                .map(ExternalUrlResponse::url)
                .orElse("");
    }

    private static Long extractFollowers(final ArtistResponse artist) {
        return Optional.ofNullable(artist.followers())
                .map(FollowersResponse::total)
                .orElse(0L);
    }

    private Set<Image> mapImages(final List<ImageResponse> images) {
        return images.stream()
                .map(this::mapImage)
                .collect(Collectors.toSet());
    }

    private Image mapImage(final ImageResponse image) {
        return Image.with(image.height(), image.url(), image.width());
    }
}
