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
    String message;
    
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
                    message = new String(bytes, 0, n);
                    System.out.println("MESSAGE RECU : " + message);
                    if(message.equals("/userlist")){
                        System.out.println("EQUALS /userlist");
                        System.out.println("USERLIST REÇU");
                        n = in.read(bytes);
                        Client.fenetre.setUsers(new String(bytes, 0, n));
                    }
                    else{
                        Client.fenetre.updateChat(message);
                    }
                    /*if(message.contains("connecté")){
                        Client.getUserList();
                    }*/
                }
            }
        }
        catch(IOException e){e.printStackTrace();}
        
    }
    
}
