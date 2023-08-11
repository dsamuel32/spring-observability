package dev.diego.spotifyconsumerapi.artist.controllers;

import dev.diego.spotifyconsumerapi.Pageable;
import dev.diego.spotifyconsumerapi.UseCase;
import dev.diego.spotifyconsumerapi.artist.ArtistOutput;
import dev.diego.spotifyconsumerapi.artist.SearchArtistInput;
import dev.diego.spotifyconsumerapi.artist.controllers.response.PageableArtistResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ArtistController implements ArtistAPI {

    private final UseCase<SearchArtistInput, Pageable<ArtistOutput>> useCase;
    @Override
    public PageableArtistResponse search(String artistsName, Integer itemsPerPages, Integer pageNumber) {
        final var input = new SearchArtistInput(artistsName, itemsPerPages, pageNumber);
        final var result = useCase.execute(input);
        return PageableArtistResponse.from(result);
    }
}
