package dev.diego.spotifyconsumerapi.infra.clients.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Set;

public record ArtistResponse(
        @JsonProperty("id")
        String id,
        @JsonProperty("name")
        String name,
        @JsonProperty("followers")
        FollowersResponse followers,
        @JsonProperty("popularity")
        Long popularity,
        @JsonProperty("external_urls")
        ExternalUrlResponse url,
        @JsonProperty("uri")
        String deepLink,
        @JsonProperty("genres")
        Set<String> genres,
        @JsonProperty("images")
        List<ImageResponse> images

) {}
