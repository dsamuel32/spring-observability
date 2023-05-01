package dev.diego.spotifyconsumerapi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {


    @Test
    void given_aValidItemsPerPageAndaValidPageNumber_returnSearchValues() {
        final var expected = Search.with("band 1", 10, 1);
        final var result = Search.with("band 1", 10, 1);
        assertEquals(expected, result);
    }
    @Test
    void given_nullItemsPerPageAndNullPageNumber_returnSearchWithDefaultValues() {
        final var expected = Search.with("band 1", 100, 0);
        final var result = Search.with("band 1", null, null);
        assertEquals(expected, result);
    }

    @Test
    void given_NegativeItemsPerPageAndNegativePageNumber_returnSearchWithDefaultValues() {
        final var expected = Search.with("band 1", 100, 0);
        final var result = Search.with("band 1", -2, -1);
        assertEquals(expected, result);
    }

}