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
    private static final int ONE = 1;
    private static final int FIFTY = 50;
    private final String artistName;
    private final Integer itemsPerPage;
    private final Integer pageNumber;

    public static Search with(final String artistName, final Integer itemsPerPage, final Integer pageNumber) {

        final var perPage = getDefaultValueItemsPerPage(itemsPerPage);
        final var page = getDefaultValuePageNumber(pageNumber);

        return new Search(artistName, perPage, page);
    }

    public Integer getOffset() {
        return Optional.ofNullable(pageNumber)
                .filter(isEqualsZero())
                .map(it -> (it + ONE) * itemsPerPage)
                .orElse(ZERO);
    }

    private static Integer getDefaultValueItemsPerPage(final Integer itemsPerPage) {
        return Optional.ofNullable(itemsPerPage)
                .filter(isEqualsZero())
                .orElse(FIFTY);
    }

    private static Integer getDefaultValuePageNumber(final Integer pageNumber) {
        return Optional.ofNullable(pageNumber)
                .filter(isEqualsZero())
                .orElse(ZERO);
    }

    private static Predicate<Integer> isEqualsZero() {
        return it -> it > ZERO;
    }

}
