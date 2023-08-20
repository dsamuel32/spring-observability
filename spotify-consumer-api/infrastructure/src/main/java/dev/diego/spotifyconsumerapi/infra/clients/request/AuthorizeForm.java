package dev.diego.spotifyconsumerapi.infra.clients.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import feign.form.FormProperty;

public record AuthorizeForm(
        @FormProperty("grant_type")
        @JsonProperty("grant_type")
        String grantType
) {
}
