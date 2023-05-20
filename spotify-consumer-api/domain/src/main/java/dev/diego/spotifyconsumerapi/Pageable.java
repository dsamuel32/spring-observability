package dev.diego.spotifyconsumerapi;

import lombok.*;

import java.util.List;
import java.util.function.Function;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public class Pageable<T> {

    private final List<T> items;
    private final Integer itemsPerPage;
    private final Integer pageNumber;
    private final Integer total;

    public static <T> Pageable<T> with(final List<T> items, final Integer itemsPerPage, final Integer pageNumber, Integer total) {
        return new Pageable<>(items, itemsPerPage, pageNumber, total);
    }

    public <R> Pageable<R> map(final Function<T, R> mapper) {
        final List<R> list = this.items.stream()
                .map(mapper)
                .toList();

        return new Pageable<>(list, itemsPerPage, pageNumber, total);
    }

}
