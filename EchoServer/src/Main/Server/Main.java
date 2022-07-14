package Main.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args)
    {
	  // start the Server his logic's build in Echo class that extend threads
	   try(ServerSocket ServerSocket = new ServerSocket(5000))
       {
           while (true)
           {
               Socket socket = ServerSocket.accept();
               Echoer echoer = new Echoer(socket);
               echoer.start();
           }
       }
       catch (IOException e)
       {
            System.out.println("Server exception " + e.getMessage());
       }
    }
}
