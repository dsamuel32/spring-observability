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
    private final String deepLink;
    private final String url;
    private final Set<String> genres;
    private final Set<Image> images;

    private Artist(
            final Id id,
            final String name,
            final Long followers,
            final Long popularity,
            final String deepLink,
            final String url,
            final Set<String> genres,
            final Set<Image> images) {
        super(id);
        this.name = name;
        this.followers = followers;
        this.popularity = popularity;
        this.deepLink = deepLink;
        this.url = url;
        this.genres = genres;
        this.images = images;
        this.validate();
    }

    public static Artist with(final String id,
                              final String name,
                              final Long followers,
                              final Long popularity,
                              final String deepLink,
                              final String url,
                              final Set<String> genres,
                              final Set<Image> images) {
        final var idValue = id != null ? Id.from(id) : Id.unique();
        return new Artist(idValue, name, followers, popularity, deepLink, url, genres, images);
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
        errors.addAll(notEmpty("deepLink", this.deepLink));
        errors.addAll(notEmpty("url", this.url));
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
