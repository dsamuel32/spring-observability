package dev.diego.spotifyconsumerapi.infra.clients;


import dev.diego.spotifyconsumerapi.infra.clients.config.FeignConfig;
import dev.diego.spotifyconsumerapi.infra.clients.request.AuthorizeForm;
import dev.diego.spotifyconsumerapi.infra.clients.response.AuthorizeResponse;
import feign.Headers;
import feign.Param;
import feign.form.FormProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@FeignClient(
        url = "${integrations.spotify.authentication.url}",
        name = "AuthorizationClient",
        configuration = FeignConfig.class
)
public interface AuthorizationClient {

    @PostMapping(value = "${integrations.spotify.authentication.path.token}",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    AuthorizeResponse authorize(@RequestHeader("Authorization") final String authorization,
                                final Map<String, String> params);

}
