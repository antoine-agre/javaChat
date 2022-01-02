package com.javachat;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    
    static byte[] bytes = new byte[64];
    static OutputStream output;
    static Scanner userInput = new Scanner(System.in);
    static String pseudo;
    
    public static void main(String[] args){
        
        System.out.println("Veuillez choisir un pseudo : ");
        pseudo = userInput.nextLine().trim();
        System.out.println("Pseudo choisi : " + pseudo);
        
        try{
            Socket connexion = new Socket("localhost", 8888);
            Thread t = new Thread(new RunnableClient(connexion));
            t.start();
            System.out.println("Connecté au serveur.");
            
            output = connexion.getOutputStream();
            
            //envoi pseudo
            output.write(pseudo.getBytes());
            
            while(true){
                bytes = userInput.nextLine().getBytes();
                output.write(bytes);
            }
            
            //gestion connexion : demander pseudo et attendre vérification
            
            //boucle réception/envoi messages
        }
        catch(IOException e){e.printStackTrace();}
            
    }
    
}
