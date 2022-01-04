package com.javachat;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class RunnableServeur implements Runnable{
    
    String clientName;
    Socket socketClient;
    InputStream stream;
    byte[] bytes = new byte[64];
    String buffMessage;
    int n;
    
    public RunnableServeur(Socket _socket){
        this.socketClient = _socket;
    }
    
    @Override
    public void run(){
        try{
            this.stream = socketClient.getInputStream();
            
            //réception et stockage du pseudo
            n = stream.read(bytes);
            clientName = new String(bytes, 0, n);
            Serveur.tableUsers.put(socketClient, clientName);
            //Serveur.enregistrerPseudo(clientName, socketClient);
            //System.out.println("Pseudo du client : " + clientName);
            Serveur.annonce(clientName + " est connecté.");
            
            while(true){
                if((n = stream.read(bytes)) != 0){
                    buffMessage = new String(bytes, 0, n);
                    //System.out.println("Client : " + buffMessage);
                    Serveur.envoyerMessage(buffMessage, socketClient);
                }
            }
        }
        catch(IOException e){e.printStackTrace();}
    }
    
}
