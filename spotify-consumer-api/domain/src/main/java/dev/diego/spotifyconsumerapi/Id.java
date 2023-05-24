package dev.diego.spotifyconsumerapi;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Objects;
import java.util.UUID;

@ToString
@EqualsAndHashCode(callSuper = true)
public class Id extends Identifier {

    private final String value;

    private Id(final String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String getValue() {
        return value;
    }

    public static Id from(final String id) {
        return new Id(id.toLowerCase());
    }
    public static Id unique() {
        final var id = UUID.randomUUID().toString().toLowerCase();
        return Id.from(id);
    }

}
