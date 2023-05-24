package dev.diego.spotifyconsumerapi.infra.clients;

import dev.diego.spotifyconsumerapi.infra.clients.response.ArtistsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
    url = "${integrations.spotify.search.url}",
    name = "SpotifyClient"
)
public interface SpotifyArtistClient {


    //market br
    //market type artist
    ArtistsResponse search(
            @RequestHeader("Authorization") final String authorization,
            @RequestParam("q") final String name,
            @RequestParam("type") final String type,
            @RequestParam("market") final String market,
            @RequestParam("limit") final Integer limit,
            @RequestParam("offset") final Integer offset
    );
}
