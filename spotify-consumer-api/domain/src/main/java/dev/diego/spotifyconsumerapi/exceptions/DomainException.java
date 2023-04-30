package dev.diego.spotifyconsumerapi.exceptions;

import java.util.List;

public class DomainException extends NoStacktraceException {

    protected final List<String> errors;

    protected DomainException(final String message, final List<String> errors) {
        super(message);
        this.errors = errors;
    }

    public static DomainException with(final String message, final List<String> errors) {
        return new DomainException(message, errors);
    }

    public List<String> getErrors() {
        return errors;
    }

}
