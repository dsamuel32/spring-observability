package dev.diego.spotifyconsumerapi.infra.clients.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SpotifyArtistResponse(
    @JsonProperty("artists")
    ArtistsResponse artists
) {}
