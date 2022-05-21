package com.udemylearing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer  extends Thread{
    private Socket socket;
    public Echoer(Socket socket)
    {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            // to get the input and streaming
            BufferedReader input = new BufferedReader(
                    new InputStreamReader((socket.getInputStream())));
            // the output of data by streaming
            PrintWriter output =new PrintWriter(socket.getOutputStream(),true
            );

            //loop until no need to our server work
            // and the stop of server done by write "exit" string
            while(true)
            {
                String echoString = input.readLine();
                System.out.println("Received client input: "  + echoString );
                if(echoString.equals("exit"))
                {
                    break;
                }
                 //sleep in need to don't have delay of connection
                 //for client
                try
                {
                    Thread.sleep(16000);

                }
                catch (InterruptedException  e)
                {
                    System.out.println(" Thread interrupted ");
                }

                output.println("Echo from server : " + echoString);

            }
        }
        catch (IOException e)
        {
            System.out.println("Ooops :" + e.getMessage());
        }
         finally
        {
                try
                {
                        socket.close();
                }
                catch (IOException e)
                {

                }
        }
    }
    }
