package server;

import commands.ICommand;
import commands.impl.CommandFactory;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class ShortenerServer {

    private CommandFactory commandFactory = new CommandFactory();

    public void connectToServer() {
        try(ServerSocket serverSocket = new ServerSocket(9991)) {
            Socket connectionSocket = serverSocket.accept();

            InputStream inputToServer = connectionSocket.getInputStream();
            OutputStream outputFromServer = connectionSocket.getOutputStream();

            Scanner scanner = new Scanner(inputToServer, "UTF-8");
            PrintWriter serverPrintOut = new PrintWriter(new OutputStreamWriter(outputFromServer, "UTF-8"), true);

            serverPrintOut.println("Enter Exit to exit");

            boolean done = false;

            while(!done && scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.toLowerCase().trim().equals("exit")) {
                    done = true;
                }

//                InetAddress address = connectionSocket.getInetAddress();
//                SocketChannel bla = connectionSocket.getChannel();
                ICommand command = commandFactory.getCommand(line);
                String res = command.execute();
                serverPrintOut.println(res);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}