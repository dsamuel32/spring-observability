package dev.diego.spotifyconsumerapi.controllers.artist;

import dev.diego.spotifyconsumerapi.controllers.artist.response.PageableArtistResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "artists")
@Tag(name = "Artists")
public interface ArtistAPI {

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Search artists")
    @ApiResponse(responseCode = "200", description = "Search artists successfully",
            content = @Content(
                    schema = @Schema(implementation = PageableArtistResponse.class)
            ))
    @ApiResponse(responseCode = "422", description = "A validation error was thrown")
    @ApiResponse(responseCode = "500", description = "An internal server error was thrown")
    PageableArtistResponse search(@RequestParam("artistsName") final String artistsName,
                                  @RequestParam(value = "itemsPerPages", defaultValue = "100") final Integer itemsPerPages,
                                  @RequestParam(value = "pageNumber", defaultValue = "0") final Integer pageNumber);

}
