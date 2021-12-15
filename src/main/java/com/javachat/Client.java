package com.javachat;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    
    static byte[] bytes = new byte[64];
    static OutputStream output;
    static Scanner userInput = new Scanner(System.in);
    
    public static void main(String[] args){
        
        try{
            Socket connexion = new Socket("localhost", 8888);
            System.out.println("Connecté au serveur.");
            
            output = connexion.getOutputStream();
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
