package dev.diego.spotifyconsumerapi.infra.clients;

import feign.Headers;
import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.logging.Level;

@Component
@Slf4j
public class AuthorizationTokenInterceptor implements RequestInterceptor {

    private String url;
    private String clientId;
    private String clientSecret;

    @Override
    public void apply(final RequestTemplate requestTemplate) {
        log.debug("[AUTHORIZATION TOKEN] - [START]");

        final var token = base64encode(clientId, clientSecret);
        final var authorization = "Basic %s".formatted(token);


        requestTemplate.header("Authorization", authorization);

        log.debug("[AUTHORIZATION TOKEN] - [END]");
    }

    private static String base64encode(final String clientId, final String clientSecret) {
        final var token = "%s:%s".formatted(clientId, clientSecret)
                .getBytes(StandardCharsets.UTF_8);

        final var encoder = Base64.getEncoder();
        return encoder.encodeToString(token);
    }
}
