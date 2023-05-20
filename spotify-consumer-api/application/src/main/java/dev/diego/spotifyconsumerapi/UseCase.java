package dev.diego.spotifyconsumerapi;

public interface UseCase <IN, OUT> {
    OUT execute(final IN in);

}
