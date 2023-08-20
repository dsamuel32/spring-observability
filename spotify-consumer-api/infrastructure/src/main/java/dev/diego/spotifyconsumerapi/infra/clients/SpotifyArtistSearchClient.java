package dev.diego.spotifyconsumerapi.infra.clients;

import dev.diego.spotifyconsumerapi.infra.clients.config.FeignConfig;
import dev.diego.spotifyconsumerapi.infra.clients.response.ArtistsResponse;
import dev.diego.spotifyconsumerapi.infra.clients.response.SpotifyArtistResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
    url = "${integrations.spotify.api.url}",
    name = "SpotifyClientSearch",
        configuration = {AuthorizationTokenInterceptor.class, FeignConfig.class}
)
public interface SpotifyArtistSearchClient {

    @GetMapping(value = "${integrations.spotify.api.paths.search}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    SpotifyArtistResponse search(
            @RequestParam("q") final String name,
            @RequestParam("type") final String type,
            @RequestParam("market") final String market,
            @RequestParam("limit") final Integer limit,
            @RequestParam("offset") final Integer offset
    );
}
