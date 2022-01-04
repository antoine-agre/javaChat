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
    boolean stop = false;
    
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
            Serveur.listePseudos.add(clientName);
            Serveur.annonce(clientName + " est connecté.");
            Serveur.broadcastUserList();
            //System.out.println("Liste pseudos : " + Serveur.listePseudos.toString());

            while(stop == false){
                if((n = stream.read(bytes)) != 0){
                    buffMessage = new String(bytes, 0, n);

                    if(buffMessage.equals("/quit")){
                        Serveur.listeSockets.remove(socketClient);
                        Serveur.tableUsers.remove(socketClient);
                        Serveur.listePseudos.remove(clientName);
                        Serveur.annonce(clientName + " est déconnecté.");
                        socketClient.close();
                        Serveur.broadcastUserList();
                        this.stop = true;
                    }
                    else{
                        Serveur.envoyerMessage(buffMessage, socketClient);
                    }
                }
            }
        }
        catch(IOException e){e.printStackTrace();}
    }
    
}
