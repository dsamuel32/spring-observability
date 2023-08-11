package dev.diego.spotifyconsumerapi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {

    @Test
    void given_aValidItemsPerPageAndaValidPageNumber_returnSearchValues() {
        final var result = Search.with("band 1", 10, 0);
        final var name = "band 1";
        final var itemsPerPage = 10;
        final var pageNumber = 0;

        assertEquals(name, result.getArtistName());
        assertEquals(itemsPerPage, result.getItemsPerPage());
        assertEquals(pageNumber, result.getPageNumber());
    }
    @Test
    void given_nullItemsPerPageAndNullPageNumber_returnSearchWithDefaultValues() {
        final var result = Search.with("band 1", null, null);

        final var name = "band 1";
        final var itemsPerPage = 100;
        final var pageNumber = 0;

        assertEquals(name, result.getArtistName());
        assertEquals(itemsPerPage, result.getItemsPerPage());
        assertEquals(pageNumber, result.getPageNumber());
    }

    @Test
    void given_ItemsPerPageTenAndPageNumberOne_returnSearchWithPageNumberTen() {
        final var result = Search.with("band 1", 10, 1);
        final var name = "band 1";
        final var itemsPerPage = 10;
        final var pageNumber = 10;
        assertEquals(name, result.getArtistName());
        assertEquals(itemsPerPage, result.getItemsPerPage());
        assertEquals(pageNumber, result.getPageNumber());
    }

    @Test
    void given_NegativeItemsPerPageAndNegativePageNumber_returnSearchWithDefaultValues() {
        final var result = Search.with("band 1", -2, -1);
        final var name = "band 1";
        final var itemsPerPage = 100;
        final var pageNumber = 0;

        assertEquals(name, result.getArtistName());
        assertEquals(itemsPerPage, result.getItemsPerPage());
        assertEquals(pageNumber, result.getPageNumber());
    }

}