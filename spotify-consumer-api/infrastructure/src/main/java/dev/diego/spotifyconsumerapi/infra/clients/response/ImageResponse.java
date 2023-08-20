package dev.diego.spotifyconsumerapi.infra.clients.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public record ImageResponse(
        @JsonProperty("height")
        Integer height,
        @JsonProperty("url")
        String url,
        @JsonProperty("width")
        Integer width
) {
}
