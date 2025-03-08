package com.stpunk47.spring_6_webclient.client;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Map;

@Service
public class BeerClientImpl implements BeerClient {

    public static final String BEER_PATH = "/api/v3/beer";
    private final WebClient webClient;

    public BeerClientImpl(WebClient.Builder webclientBuilder) {
        this.webClient = webclientBuilder
                .baseUrl("http://localhost:8080")
                .build();
    }

    @Override
    public Flux<String> listBeer() {
        return webClient.get().uri(BEER_PATH, String.class)
                .retrieve().bodyToFlux(String.class);
    }

    @Override
    public Flux<Map> listBeerMap() {
        return webClient.get().uri(BEER_PATH, Map.class)
                .retrieve().bodyToFlux(Map.class);
    }
}
