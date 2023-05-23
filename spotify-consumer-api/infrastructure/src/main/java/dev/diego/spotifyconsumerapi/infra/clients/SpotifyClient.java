package dev.diego.spotifyconsumerapi.infra.clients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
    url = "${integrations.spotify.search.url}",
    name = "SpotifyClient"
)
public interface SpotifyClient {
}
