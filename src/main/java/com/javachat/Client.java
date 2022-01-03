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
    static boolean stop = false;
    
    public static void main(String[] args){
        
        System.out.println("Veuillez choisir un pseudo : ");
        pseudo = userInput.nextLine().trim();
        System.out.println("Pseudo choisi : " + pseudo);
        
        try{
            Socket connexion = new Socket("localhost", 8888);
            Thread t = new Thread(new RunnableClient(connexion));
            t.start();
            System.out.println("Connecté au serveur.");
            System.out.println("Tapez '/quit' pour vous déconnecter et quitter l'application.");
            
            output = connexion.getOutputStream();
            
            //envoi pseudo
            output.write(pseudo.getBytes());
            
            while(stop == false){
                bytes = userInput.nextLine().getBytes();
                output.write(bytes);
                if(new String(bytes, 0, bytes.length).equals("/quit")){
                    connexion.close();
                    stop = true;
                }
            }
        }
        catch(IOException e){e.printStackTrace();}
            
        System.exit(0);
    }
    
}
