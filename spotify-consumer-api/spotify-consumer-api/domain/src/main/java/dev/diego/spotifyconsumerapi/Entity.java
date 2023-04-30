package dev.diego.spotifyconsumerapi;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
@EqualsAndHashCode
public abstract class Entity <ID extends Identifier> {

    protected final ID id;

    protected Entity(final ID id) {
        this.id = Objects.requireNonNull(id, "'id' should not be null");
    }

}
