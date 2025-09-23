package ru.netology.rest;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class TestServer {
    private static HttpServer server;

    public static void start() throws IOException {
        server = HttpServer.create(new InetSocketAddress(9999), 0);

        // Обработчик для /api/v1/demo/accounts
        server.createContext("/api/v1/demo/accounts", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                if ("GET".equals(exchange.getRequestMethod())) {
                    String response = "[" +
                            "{\"id\": 1, \"name\": \"Account1\", \"balance\": 1000}," +
                            "{\"id\": 2, \"name\": \"Account2\", \"balance\": 2000}" +
                            "]";

                    exchange.getResponseHeaders().set("Content-Type", "application/json");
                    exchange.sendResponseHeaders(200, response.getBytes().length);

                    OutputStream os = exchange.getResponseBody();
                    os.write(response.getBytes());
                    os.close();
                } else {
                    exchange.sendResponseHeaders(405, -1); // Method Not Allowed
                }
            }
        });

        server.start();
        System.out.println("Test server started on port 9999");
    }

    public static void stop() {
        if (server != null) {
            server.stop(0);
            System.out.println("Test server stopped");
        }
    }
}