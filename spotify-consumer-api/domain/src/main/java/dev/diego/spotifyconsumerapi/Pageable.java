package dev.diego.spotifyconsumerapi;

import lombok.*;

import java.util.List;

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

}
