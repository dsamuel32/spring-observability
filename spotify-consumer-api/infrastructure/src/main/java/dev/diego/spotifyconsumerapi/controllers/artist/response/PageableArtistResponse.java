package dev.diego.spotifyconsumerapi.controllers.artist.response;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;

public record PageableArtistResponse(
        @Schema(description = "Total artists found", example = "10")
        Integer total,
        @Schema(description = "Search page number", example = "0")
        Integer pageNumber
) {
}
