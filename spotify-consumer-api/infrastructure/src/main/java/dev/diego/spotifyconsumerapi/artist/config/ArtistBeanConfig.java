package dev.diego.spotifyconsumerapi.artist.config;

import dev.diego.spotifyconsumerapi.Pageable;
import dev.diego.spotifyconsumerapi.UseCase;
import dev.diego.spotifyconsumerapi.artist.ArtistGateway;
import dev.diego.spotifyconsumerapi.artist.ArtistOutput;
import dev.diego.spotifyconsumerapi.artist.SearchArtistInput;
import dev.diego.spotifyconsumerapi.artist.SearchArtistUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ArtistBeanConfig {

    private final ArtistGateway gateway;

    @Bean
    public UseCase<SearchArtistInput, Pageable<ArtistOutput>> searchArtistUseCase() {
        return new SearchArtistUseCase(gateway);
    }
}
