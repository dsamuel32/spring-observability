package dev.diego.spotifyconsumerapi.artist;

import dev.diego.spotifyconsumerapi.exceptions.DomainException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArtistTest {

    @Test
    void given_nullFields_shouldNotCreateArtist() {
        final var expectedMessage = "Invalid fields";
        final var expectedInvalidFields = List.of(
                "'name' should not be null",
                "'name' should not be empty",
                "'followers' should not be null",
                "'popularity' should not be null",
                "'deepLink' should not be null",
                "'deepLink' should not be empty",
                "'url' should not be null",
                "'url' should not be empty",
                "'genres' should not be null",
                "'images' should not be null"
        );

        final var result = assertThrows(
                DomainException.class,
                () -> Artist.with(null, null, null,null, null, null, null, null));

        assertEquals(expectedMessage, result.getMessage());
        assertEquals(sort(expectedInvalidFields), sort(result.getErrors()));
    }

    @Test
    void given_emptyFields_shouldNotCreateArtist() {
        final var expectedMessage = "Invalid fields";
        final var expectedInvalidFields = List.of(
                "'name' should not be empty",
                "'followers' should not be null",
                "'popularity' should not be null",
                "'deepLink' should not be empty",
                "'url' should not be empty",
                "'genres' should not be null",
                "'images' should not be null"
        );

        final var result = assertThrows(
                DomainException.class,
                () -> Artist.with(null,"      ", null, null,"", "", null, null));

        assertEquals(expectedMessage, result.getMessage());
        assertEquals(sort(expectedInvalidFields), sort(result.getErrors()));
    }

    private List<String> sort(final List<String> errors) {
        return errors.stream().sorted().toList();
    }

}