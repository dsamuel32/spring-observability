package dev.diego.spotifyconsumerapi.infra.clients.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthorizeResponse(
        @JsonProperty("access_token")
        String token,
        @JsonProperty("token_type")
        String tokenType,
        @JsonProperty("expires_in")
        Long expiresIn
) { }
