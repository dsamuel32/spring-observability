package dev.diego.spotifyconsumerapi.artist;

import dev.diego.spotifyconsumerapi.Pageable;
import dev.diego.spotifyconsumerapi.Search;
import dev.diego.spotifyconsumerapi.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class SearchArtistUseCase implements UseCase<SearchArtistInput, Pageable<ArtistOutput>> {

    private final ArtistGateway gateway;
    @Override
    public Pageable<ArtistOutput> execute(final SearchArtistInput input) {
        log.info("[SEARCH ARTIST][START] - {}", input);
        final var search = Search.with(input.artistName(), input.itemsPerPage(), input.pageNumber());
        final var result = gateway.search(search);
        log.info("[SEARCH ARTIST][END] - Found: {}", result.getTotal());
        return result.map(ArtistOutput::from);
    }

}
