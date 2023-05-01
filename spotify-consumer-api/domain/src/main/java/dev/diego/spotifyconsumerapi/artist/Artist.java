package dev.diego.spotifyconsumerapi.artist;

import dev.diego.spotifyconsumerapi.AggregateRoot;
import dev.diego.spotifyconsumerapi.Id;
import dev.diego.spotifyconsumerapi.exceptions.DomainException;
import lombok.Getter;
import lombok.ToString;

import java.util.*;

@Getter
@ToString
public class Artist extends AggregateRoot<Id> {

    private static final int ZERO = 0;

    private final String name;
    private final Long followers;
    private final Long popularity;
    private final String uri;
    private final Set<String> genres;
    private final Set<Image> images;

    private Artist(
            final Id id,
            final String name,
            final Long followers,
            final Long popularity,
            final String uri,
            final Set<String> genres,
            final Set<Image> images) {

        super(id);
        this.name = name;
        this.followers = followers;
        this.popularity = popularity;
        this.uri = uri;
        this.genres = genres;
        this.images = images;
        this.validate();
    }

    public static Artist with(final String name,
                       final Long followers,
                       final Long popularity,
                       final String uri,
                       final Set<String> genres,
                       final Set<Image> images) {
        final var id = Id.unique();
        return new Artist(id, name, followers, popularity, uri, genres, images);
    }

    private void validate() {
        final var errors = validateFields();

        if (!errors.isEmpty()) {
            throw DomainException.with("Invalid fields", errors);
        }

    }

    private List<String> validateFields() {
        final var errors = new ArrayList<String>();

        errors.addAll(notEmpty("name", this.name));
        errors.addAll(notNull("followers", this.followers));
        errors.addAll(notNull("popularity", this.popularity));
        errors.addAll(notEmpty("uri", this.uri));
        errors.addAll(notNull("genres", this.genres));
        errors.addAll(notNull("images", this.images));

        return errors;

    }


    private List<String> notEmpty(final String name, final String value) {
        final var errors = notNull(name, value);

        final var field = Optional.ofNullable(value)
                .map(String::trim)
                .orElse("");

        if (field.length() == ZERO) {
            final var error = "'%s' should not be empty".formatted(name);
            errors.add(error);
        }

        return errors;
    }

    private List<String> notNull(final String name, final Object value) {
        final var errors = new ArrayList<String>();

        if (Objects.isNull(value)) {
            final var error = "'%s' should not be null".formatted(name);
            errors.add(error);
        }

        return errors;
    }

}
