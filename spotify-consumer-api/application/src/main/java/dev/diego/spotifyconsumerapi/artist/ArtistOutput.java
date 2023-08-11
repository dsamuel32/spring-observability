package dev.diego.spotifyconsumerapi.artist;

import java.util.Set;
import java.util.stream.Collectors;

public record ArtistOutput(
        String id,
        String name,
        Long followers,
        Long popularity,
        String deepLink,
        String url,
        Set<String> genres,
        Set<ImageOutput> images
) {

    public static ArtistOutput from(final Artist artist) {
        final var images = artist.getImages()
                .stream().map(it -> new ImageOutput(it.getWight(), it.getUri(), it.getHeight()))
                .collect(Collectors.toSet());

        return new ArtistOutput(
                artist.getId().getValue(),
                artist.getName(),
                artist.getFollowers(),
                artist.getPopularity(),
                artist.getDeepLink(),
                artist.getUrl(),
                artist.getGenres(),
                images
        );
    }

}
