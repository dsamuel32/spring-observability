package dev.diego.spotifyconsumerapi.infra.clients.request;

import feign.form.FormProperty;

public record AuthorizeForm(
        @FormProperty("grant_type")
        String grantType
) {
}
