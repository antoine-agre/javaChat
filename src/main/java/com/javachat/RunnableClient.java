package com.javachat;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.sql.Struct;

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
                    //System.out.println(new String(bytes, 0, n));
                    System.out.println("Message reçu : " + new String(bytes, 0, n));
                    Client.fenetre.updateChat(new String(bytes, 0, n));
                    System.out.println("Nouveau chatContent : " + Client.fenetre.chatContent);
                }
            }
        }
        catch(IOException e){e.printStackTrace();}
        
    }
    
}
