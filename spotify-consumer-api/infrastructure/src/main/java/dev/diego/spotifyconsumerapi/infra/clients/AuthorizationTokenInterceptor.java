package dev.diego.spotifyconsumerapi.infra.clients;

import dev.diego.spotifyconsumerapi.infra.clients.response.AuthorizeResponse;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Map;

@Component
@Slf4j
@RequiredArgsConstructor
public class AuthorizationTokenInterceptor implements RequestInterceptor {

    @Value("${integrations.spotify.authentication.client-id}")
    private String clientId;

    @Value("${integrations.spotify.authentication.client-secret}")
    private String clientSecret;

    private final AuthorizationClient client;

    private LocalDateTime expires = LocalDateTime.now();
    private String authorizationToken;

    @Override
    public void apply(final RequestTemplate requestTemplate) {
        log.debug("[AUTHORIZATION TOKEN] - [START]");

        final var bearerToken = getAuthorizationToken();
        requestTemplate.header("Authorization", bearerToken);

        log.debug("[AUTHORIZATION TOKEN] - [END]");
    }

    private static String base64encode(final String clientId, final String clientSecret) {
        final var token = "%s:%s".formatted(clientId, clientSecret)
                .getBytes(StandardCharsets.UTF_8);

        final var encoder = Base64.getEncoder();
        return encoder.encodeToString(token);
    }

    private synchronized String getAuthorizationToken() {
        if (expires.isAfter(LocalDateTime.now())) {
            return authorizationToken;
        } else {
            log.info("[AUTHORIZATION TOKEN] - [TOKEN] Expired");
            final var response = retrieveAuthorizationToken();
            final var bearerToken = String.format("%s %s", response.tokenType(), response.token());
            expires = expires.plusMinutes(response.expiresIn());
            authorizationToken = bearerToken;
            return authorizationToken;
        }

    }

    private AuthorizeResponse retrieveAuthorizationToken() {
        final var token = base64encode(clientId, clientSecret);
        final var authorization = "Basic %s".formatted(token);
        return client.authorize(authorization, Map.of("grant_type", "client_credentials"));
    }
}
