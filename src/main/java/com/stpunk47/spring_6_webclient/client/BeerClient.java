package com.stpunk47.spring_6_webclient.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.stpunk47.spring_6_webclient.model.BeerDTO;
import reactor.core.publisher.Flux;

import java.util.Map;
import java.util.concurrent.Flow;

public interface BeerClient {

    Flux<String> listBeer();

    Flux<Map> listBeerMap();

    Flux<JsonNode> listBeersJsonNode();

    Flux<BeerDTO> listBeerDtos();
}
