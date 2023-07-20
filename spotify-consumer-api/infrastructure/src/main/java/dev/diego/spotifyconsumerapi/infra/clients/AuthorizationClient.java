package dev.diego.spotifyconsumerapi.infra.clients;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        url = "${integrations.spotify.authentication.url}",
        name = "SpotifyClientSearch"
)
public interface AuthorizationClient {
}
