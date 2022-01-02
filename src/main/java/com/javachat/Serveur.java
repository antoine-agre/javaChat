package com.javachat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Hashtable;

public class Serveur {
    
    static ArrayList<Thread> listeThreads = new ArrayList<>();
    static ArrayList<String> listePseudos = new ArrayList<>();
    static ArrayList<Socket> listeSockets = new ArrayList<>();
    static Hashtable<Socket, String> tableUsers = new Hashtable<Socket, String>();
    
    /*Envoie un message à tous les sockets de la liste.*/
    protected static void envoyerMessage(String contenu, Socket socket){
        
        String message = tableUsers.get(socket) + " : " + contenu;
        byte[] bytes = message.getBytes();
        
        try{
            for(Socket s : listeSockets){
                s.getOutputStream().write(bytes);
            }
            System.out.println(new String(bytes));
        }
        catch(IOException e){e.printStackTrace();}
    }
    
    /*Demande l'envoi d'un message d'annonce à tous les sockets de la liste.*/
    protected static void annonce(String message){
        try{
            for(Socket s : listeSockets){
                s.getOutputStream().write(message.getBytes());
            }
            System.out.println(message);
        }
        catch(IOException e){e.printStackTrace();}
    }
    
    public static void main(String[] args){
        try{
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Socket serveur créée.");

            //boucle infinie : accepte connexions, gère threads
            Socket nouveauClient;
            
            while(true){
                    nouveauClient = serverSocket.accept();
                    listeSockets.add(nouveauClient);
                    System.out.println("Connextion établie avec un client.");

                    Thread t = new Thread(new RunnableServeur(nouveauClient));
                    t.start();
                
                
                
            }

        }
        catch(IOException e){e.printStackTrace();}
    }
}
