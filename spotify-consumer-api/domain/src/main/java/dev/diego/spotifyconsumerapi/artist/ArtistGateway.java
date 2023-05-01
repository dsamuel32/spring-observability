package dev.diego.spotifyconsumerapi.artist;

import dev.diego.spotifyconsumerapi.Pageable;
import dev.diego.spotifyconsumerapi.Search;

public interface ArtistGateway {

    Pageable<Artist> search(final Search search);

}
