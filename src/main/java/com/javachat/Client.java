package com.javachat;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    
    static byte[] bytes = new byte[64];
    static OutputStream output;
    static Scanner userInput = new Scanner(System.in);
    static String pseudo;
    static boolean stop = false;
    static FenetreChat fenetre;
    static Socket connexion;
    
    static void loginToServer(){
        try{
            connexion = new Socket("localhost", 8888);
            Thread t = new Thread(new RunnableClient(connexion));
            t.start();
            output = connexion.getOutputStream();
            
            //envoi pseudo
            
            output.write(pseudo.getBytes());
        }
        catch(IOException e){e.printStackTrace();}
    }
    
    static void envoyerMessage(){
        try{
            bytes = fenetre.getInput().getBytes();
            output.write(bytes);
            if(new String(bytes, 0, bytes.length).equals("/quit")){
                connexion.close();
                //stop = true;
                fenetre.setVisible(false);
            }
        }
        catch(IOException e){e.printStackTrace();}
    }
    
    /*static void getUserList(){
        try{
            bytes = new String("/users").getBytes();
            output.write(bytes);
        }
        catch(IOException e){e.printStackTrace();}
    }*/
    
    public static void main(String[] args){
        
        //SaisiePseudo fenetreLogin = new SaisiePseudo(); 
        //fenetreLogin.setVisible(true);
        fenetre = new FenetreChat();
        new SaisiePseudo(fenetre).setVisible(true);
        
        //while(true){System.out.println("ListePseudos : " + Serveur.listePseudos.toString());}
        
        
        /*System.out.println("Veuillez choisir un pseudo : ");
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
            
        System.exit(0);*/
    }
    
}
