package com.javachat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Serveur {
    
    static ArrayList<Thread> listeThreads = new ArrayList<>();
    static ArrayList<String> listePseudos = new ArrayList<>();
    static ArrayList<Socket> listeSockets = new ArrayList<>();
    
    /*Envoie un message à tous les sockets de la liste.*/
    protected static void envoyerMessage(byte[] b){
        
        try{
            for(Socket s : listeSockets){
                s.getOutputStream().write(b);
            }
        }
        catch(IOException e){e.printStackTrace();}
    }
    
    
    public static void main(String[] args){
        try{
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Socket serveur créée.");

            //boucle infinie : accepte connexions, gère threads
            Socket nouveauClient;
            
            //while(true){
                for(int i = 0; i < 2; i++){
                    nouveauClient = serverSocket.accept();
                    listeSockets.add(nouveauClient);
                    System.out.println("Connextion établie avec un client.");

                    Thread t = new Thread(new RunnableServeur(nouveauClient));
                    t.start();
                }
                
                
                
            //}

        }
        catch(IOException e){e.printStackTrace();}
    }
}
