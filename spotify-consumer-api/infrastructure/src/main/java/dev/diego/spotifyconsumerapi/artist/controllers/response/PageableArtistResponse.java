package dev.diego.spotifyconsumerapi.artist.controllers.response;

import dev.diego.spotifyconsumerapi.Pageable;
import dev.diego.spotifyconsumerapi.artist.ArtistOutput;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record PageableArtistResponse(
        @Schema(description = "Total artists found", example = "10")
        Integer total,
        @Schema(description = "Search page number", example = "0")
        Integer pageNumber,
        @Schema(description = "List of artists")
        List<ArtistResponse> items
) {

    public static PageableArtistResponse from(final Pageable<ArtistOutput> pageable) {
        final var artists = pageable.getItems().stream().map(ArtistResponse::from).toList();
        return new PageableArtistResponse(
                pageable.getTotal(),
                pageable.getPageNumber(),
                artists
        );
    }
}
