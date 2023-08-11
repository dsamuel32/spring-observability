package dev.diego.spotifyconsumerapi.infra.clients;

import dev.diego.spotifyconsumerapi.infra.clients.config.FeignConfig;
import dev.diego.spotifyconsumerapi.infra.clients.response.ArtistsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
    url = "${integrations.spotify.api.url}",
    name = "SpotifyClientSearch",
        configuration = {AuthorizationTokenInterceptor.class, FeignConfig.class}
)
public interface SpotifyArtistSearchClient {


    //market br
    //market type artist
    @GetMapping("${integrations.spotify.api.url.paths.search}")
    ArtistsResponse search(
            @RequestParam("q") final String name,
            @RequestParam("type") final String type,
            @RequestParam("market") final String market,
            @RequestParam("limit") final Integer limit,
            @RequestParam("offset") final Integer offset
    );
}
