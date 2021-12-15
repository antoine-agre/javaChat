package com.javachat;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class RunnableServeur implements Runnable{
    
    String name;
    Socket socketClient;
    InputStream stream;
    byte[] bytes = new byte[64];
    int n;
    
    public RunnableServeur(Socket _socket){
        this.socketClient = _socket;
    }
    
    @Override
    public void run(){
        try{
            this.stream = socketClient.getInputStream();
            while(true){
                if((n = stream.read(bytes)) != 0){
                    System.out.println("Client : " + new String(bytes, 0, n));
                }
            }
        }
        catch(IOException e){e.printStackTrace();}
    }
    
}
