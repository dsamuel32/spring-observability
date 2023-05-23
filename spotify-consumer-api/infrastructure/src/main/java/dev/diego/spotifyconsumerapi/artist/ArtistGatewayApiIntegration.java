package dev.diego.spotifyconsumerapi.artist;

import dev.diego.spotifyconsumerapi.Pageable;
import dev.diego.spotifyconsumerapi.Search;
import org.springframework.stereotype.Component;

@Component
public class ArtistGatewayApiIntegration implements ArtistGateway {
    @Override
    public Pageable<Artist> search(final Search search) {
        return null;
    }
}
