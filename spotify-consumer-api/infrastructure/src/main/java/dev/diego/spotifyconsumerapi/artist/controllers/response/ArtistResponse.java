package dev.diego.spotifyconsumerapi.artist.controllers.response;

import dev.diego.spotifyconsumerapi.artist.ArtistOutput;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Set;
import java.util.stream.Collectors;

public record ArtistResponse(
        @Schema(description = "Identifier", example = "123")
        String id,

        @Schema(description = "Artist name", example = "Band 1")
        String name,

        @Schema(description = "Total followers", example = "10000")
        Long followers,
        @Schema(description = "Popularity artists", example = "10")
        Long popularity,

        @Schema(description = "Deep link Spotfy app", example = "spoty:deeplink")
        String uri,
        @Schema(description = "Artist music genres", example = "Rock")
        Set<String> genres,
        @Schema(description = "Album images")
        Set<ImageResponse> images
) {
    public static ArtistResponse from(final ArtistOutput artist) {
        final var images = artist.images()
                .stream()
                .map(ImageResponse::from)
                .collect(Collectors.toSet());

        return new ArtistResponse(
                artist.id(),
                artist.name(),
                artist.followers(),
                artist.popularity(),
                artist.uri(),
                artist.genres(),
                images
        );
    }
}
