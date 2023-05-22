package dev.diego.spotifyconsumerapi.controllers.artist;

import dev.diego.spotifyconsumerapi.controllers.artist.response.PageableArtistResponse;

public class ArtistController implements ArtistAPI{

    @Override
    public PageableArtistResponse search(String artistsName, Integer itemsPerPages, Integer pageNumber) {
        return null;
    }
}
