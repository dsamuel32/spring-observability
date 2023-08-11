package dev.diego.spotifyconsumerapi.artist;

import dev.diego.spotifyconsumerapi.Pageable;
import dev.diego.spotifyconsumerapi.Search;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SearchArtistUseCaseTest {

    @InjectMocks
    private SearchArtistUseCase useCase;

    @Mock
    private ArtistGateway gateway;

    @Test
    void given_aSearchInputWithArtistNameField_returnPageableArtistEmpty() {

        when(gateway.search(any(Search.class))).thenReturn(Pageable.with(Collections.emptyList(), 1, 0, 0));
        final var input = SearchArtistInput.with("band 1", null, null);
        final var result = useCase.execute(input);

        final var expected = Pageable.with(Collections.emptyList(), 1, 0, 0);

        assertEquals(expected, result);
        verify(gateway).search(Search.with("band 1", 100, 0));

    }

    @ParameterizedTest
    @CsvSource(
            value = {"band 1, 1, 1", "band 1, 1, 2"}
    )
    void given_aSearchInputWithArtistNameAndPageNumberAndItemsPerPage_returnPageableArtistPage(
            final String name, final Integer itemsPerPage, final Integer pageNumber) {

        final var artist = createArtist();

        when(gateway.search(any(Search.class))).thenReturn(createPageableArtist(artist, pageNumber));
        final var input = SearchArtistInput.with(name, itemsPerPage, pageNumber);
        final var result = useCase.execute(input);

        final var expected = createPageableArtistOutput(artist, pageNumber);

        assertEquals(expected, result);
        verify(gateway).search(Search.with(name, itemsPerPage, pageNumber));

    }

    private Artist createArtist() {
        return Artist.with(
                "band 1",
                1000L,
                10L,
                "spotfy:fake.deepLink",
                Set.of("Rock", "Metal"),
                Set.of(Image.with(10, "spotfy:fake.deepLink", 10))
        );
    }

    private Pageable<Artist> createPageableArtist(final Artist artist, final Integer pageNumber) {
        return Pageable.with(
                List.of(artist),
                1,
                pageNumber,
                10
        );
    }

    private Pageable<ArtistOutput> createPageableArtistOutput(final Artist artist, final Integer pageNumber) {
        return Pageable.with(
                List.of(ArtistOutput.from(artist)),
                1,
                pageNumber,
                10
        );
    }

}