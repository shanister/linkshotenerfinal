package main;

import server.ShortenerServer;

public class ShortenerUrlMain {

    private static ShortenerServer server = new ShortenerServer();

    public static void main(String[] args) {
        server.connectToServer();
    }

}
