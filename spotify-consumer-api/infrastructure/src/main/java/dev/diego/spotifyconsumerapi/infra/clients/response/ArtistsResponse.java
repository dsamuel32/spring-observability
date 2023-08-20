package dev.diego.spotifyconsumerapi.infra.clients.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ArtistsResponse(
        @JsonProperty("followers")
        Integer limit,
        @JsonProperty("offset")
        Integer offset,
        @JsonProperty("total")
        Integer total,
        @JsonProperty("items")
        List<ArtistResponse> artists
) {
}
