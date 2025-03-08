package com.stpunk47.spring_6_webclient.client;

import reactor.core.publisher.Flux;

public interface BeerClient {

    Flux<String> listBeer();


}
