package dev.diego.spotifyconsumerapi.artist;

import dev.diego.spotifyconsumerapi.ValueObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@EqualsAndHashCode
@ToString
public class Image implements ValueObject {

    private final Integer height;
    private final String uri;
    private final String wight;

    private Image(Integer height, String uri, String wight) {
        this.height = Objects.requireNonNull(height, "'height' should not be null");
        this.uri = Objects.requireNonNull(uri, "'uri' should not be null");
        this.wight = Objects.requireNonNull(wight, "'wight' should not be null");
    }

    public static Image with(final Integer height, final String uri, final String wight) {
        return new Image(height, uri, wight);
    }

}
