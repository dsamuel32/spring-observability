package dev.diego.spotifyconsumerapi;

import lombok.*;

import java.util.Optional;
import java.util.function.Predicate;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public class Search {

    private static final int ZERO = 0;
    private static final int ONE_HUNDRED = 100;
    private final String artistName;
    private final Integer itemsPerPage;
    private final Integer pageNumber;

    public static Search with(final String artistName, final Integer itemsPerPage, final Integer pageNumber) {

        final var page = getDefaultValuePageNumber(pageNumber);
        final var perPage = getDefaultValueItemsPerPage(itemsPerPage);

        return new Search(artistName, perPage, page);
    }

    private static Integer getDefaultValueItemsPerPage(final Integer itemsPerPage) {
        return Optional.ofNullable(itemsPerPage)
                .filter(isEqualsMoreThenZero())
                .orElse(ONE_HUNDRED);
    }

    private static Integer getDefaultValuePageNumber(final Integer pageNumber) {
        return Optional.ofNullable(pageNumber)
                .filter(isEqualsMoreThenZero())
                .orElse(ZERO);
    }

    private static Predicate<Integer> isEqualsMoreThenZero() {
        return it -> it >= ZERO;
    }

}
