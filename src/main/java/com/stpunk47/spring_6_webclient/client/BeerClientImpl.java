package com.stpunk47.spring_6_webclient.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.stpunk47.spring_6_webclient.model.BeerDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Map;
import java.util.concurrent.Flow;

@Service
public class BeerClientImpl implements BeerClient {

    public static final String BEER_PATH = "/api/v3/beer";
    private final WebClient webClient;

    public BeerClientImpl(WebClient.Builder webclientBuilder) {
        this.webClient = webclientBuilder.build();
    }

    @Override
    public Flux<String> listBeer() {
        return webClient.get().uri(BEER_PATH)
                .retrieve().bodyToFlux(String.class);
    }

    @Override
    public Flux<Map> listBeerMap() {
        return webClient.get().uri(BEER_PATH)
                .retrieve().bodyToFlux(Map.class);
    }

    @Override
    public Flux<JsonNode> listBeersJsonNode() {
        return webClient.get().uri(BEER_PATH)
                .retrieve().bodyToFlux(JsonNode.class);
    }

    @Override
    public Flux<BeerDTO> listBeerDtos() {
        return webClient.get().uri(BEER_PATH)
                .retrieve().bodyToFlux(BeerDTO.class);
    }
}
