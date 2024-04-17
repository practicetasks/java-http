package postman.example_2;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;

public class Test {
    // GET /users
    // POST /users
    // GET /users/{userId}

    // POST /users/{userId}/posts
    // GET /users/{userId}/posts
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create();
        server.createContext("/users", new RequestHandler());
        server.start();
    }
}
