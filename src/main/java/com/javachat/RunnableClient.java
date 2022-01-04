package com.javachat;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class RunnableClient implements Runnable{
    
    //paramètres
    Socket socket;
    int n;
    byte[] bytes = new byte[64];
    
    public RunnableClient(Socket _socket){
        this.socket = _socket;
    }
    
    @Override
    public void run(){
        
        try{
            InputStream in = this.socket.getInputStream();
            while(true){
                if((n = in.read(bytes)) != 0){
                    System.out.println(new String(bytes, 0, n));
                }
            }
        }
        catch(IOException e){e.printStackTrace();}
        
    }
    
}
