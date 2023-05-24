package dev.diego.spotifyconsumerapi.artist.controllers.response;

import dev.diego.spotifyconsumerapi.artist.ImageOutput;
import io.swagger.v3.oas.annotations.media.Schema;

public record ImageResponse(
        @Schema(description = "Image height", example = "640")
        Integer height,
        @Schema(description = "Image deepLink", example = "https://somelinkimage.com")
        String uri,
        @Schema(description = "Image wight", example = "640")
        Integer wight
) {
    public static ImageResponse from(final ImageOutput image) {
        return new ImageResponse(image.height(), image.uri(), image.height());
    }
}
