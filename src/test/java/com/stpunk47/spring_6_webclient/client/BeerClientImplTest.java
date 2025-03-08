package com.stpunk47.spring_6_webclient.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerClientImplTest {

    @Autowired
    BeerClient beerClient;

    @Test
    void listBeer() {

        AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        beerClient.listBeer().subscribe(response -> {
            System.out.println(response);
            atomicBoolean.set(true);
        });

        await().untilTrue(atomicBoolean);

    }

    @Test
    void testGetMap() {

        AtomicBoolean atomicBoolean = new AtomicBoolean(false);


        beerClient.listBeerMap().subscribe(response -> {
                System.out.println(response);
                atomicBoolean.set(true);
    });

        await().untilTrue(atomicBoolean);
    }
}