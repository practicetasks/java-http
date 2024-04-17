package postman.example_2;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class RequestHandler implements HttpHandler {
    private final Map<Long, User> users = new HashMap<>();
    private final Gson gson = new Gson();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Endpoint endpoint = getEndpoint(exchange);
        switch (endpoint) {
            case GET_USERS -> {
                exchange.sendResponseHeaders(200, 0);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(gson.toJson(users.values()).getBytes());
                }
            }
            // 200 OK
            // 201 CREATED
            case POST_USER -> {
                exchange.sendResponseHeaders(201, 0);
                // TODO:
            }
            case POST_USER_POST -> {
                // TODO:
            }
        }
    }

    private Endpoint getEndpoint(HttpExchange exchange) {
        // TODO: разобрать строку и узнать на какой путь ссылается пользователь
        String url = exchange.getRequestURI().getPath();
        String method = exchange.getRequestMethod();
        // GET /users/{}
        return Endpoint.GET_USERS;
    }
}
