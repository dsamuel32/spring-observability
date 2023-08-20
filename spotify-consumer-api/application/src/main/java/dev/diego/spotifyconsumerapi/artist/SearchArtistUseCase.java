package dev.diego.spotifyconsumerapi.artist;

import dev.diego.spotifyconsumerapi.Pageable;
import dev.diego.spotifyconsumerapi.Search;
import dev.diego.spotifyconsumerapi.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.logging.Level;
import java.util.logging.Logger;

@RequiredArgsConstructor
public class SearchArtistUseCase implements UseCase<SearchArtistInput, Pageable<ArtistOutput>> {

    private final Logger LOGGER = Logger.getLogger(SearchArtistUseCase.class.getName());

    private final ArtistGateway gateway;
    @Override
    public Pageable<ArtistOutput> execute(final SearchArtistInput input) {
        LOGGER.log(Level.INFO, "[SEARCH ARTIST][START] - %s", input);
        final var search = Search.with(input.artistName(), input.itemsPerPage(), input.pageNumber());
        final var result = gateway.search(search);
        LOGGER.log(Level.INFO, "[SEARCH ARTIST][END] - Found: {}", result.getTotal());
        return result.map(ArtistOutput::from);
    }

}
