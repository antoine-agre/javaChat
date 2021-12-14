package com.main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Serveur {
    
    static ArrayList<Thread> listeThreads = new ArrayList<>();
    static ArrayList<String> listePseudos = new ArrayList<>();
    //static ArrayList<Socket> listeSockets = new ArrayList<>();
    
    
    public static void main(String[] args){
        try{
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Socket serveur créée.");

            //boucle infinie : accepte connexions, gère threads
            Socket nouveauClient;
            
            //while(true){
                for(int i = 0; i < 2; i++){
                    nouveauClient = serverSocket.accept();
                    System.out.println("Connextion établie avec un client.");

                    Thread t = new Thread(new RunnableServeur(nouveauClient));
                    t.start();
                }
                
                
                
            //}

        }
        catch(IOException e){e.printStackTrace();}
    }
}
