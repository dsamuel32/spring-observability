package dev.diego.spotifyconsumerapi.artist;

import dev.diego.spotifyconsumerapi.AggregateRoot;
import dev.diego.spotifyconsumerapi.Id;
import dev.diego.spotifyconsumerapi.exceptions.DomainException;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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

    protected Artist(
            final String name,
            final Long followers,
            final Long popularity,
            final String uri,
            final Set<String> genres,
            final Set<Image> images) {

        super(Id.unique());
        this.name = name;
        this.followers = followers;
        this.popularity = popularity;
        this.uri = uri;
        this.genres = genres;
        this.images = images;
        this.validate();
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

        if (value.length() == ZERO) {
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
