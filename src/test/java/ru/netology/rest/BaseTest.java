package ru.netology.rest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import java.io.IOException;

public class BaseTest {

    @BeforeAll
    static void startServer() throws IOException {
        TestServer.start();
        // Даем серверу время на запуск
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @AfterAll
    static void stopServer() {
        TestServer.stop();
    }
}
