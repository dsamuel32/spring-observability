package dev.diego.spotifyconsumerapi.artist;

public record SearchArtistInput(
        String artistName,
        Integer itemsPerPage,
        Integer pageNumber
) {

    public static SearchArtistInput with(
            final String artistName,
            final Integer itemsPerPage,
            final Integer pageNumber) {
        return new SearchArtistInput(artistName, itemsPerPage, pageNumber);
    }

}
