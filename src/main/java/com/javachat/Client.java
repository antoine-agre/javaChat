package com.javachat;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    
    static byte[] bytes = new byte[64];
    static OutputStream output;
    static Scanner userInput = new Scanner(System.in);
    public static String pseudo;
    static public Interface frame;
    static public InterfaceChat fram;
    static String message;
    //proprietes
    
    
    
	public static void main(String[] args){
		frame = new Interface();
    	frame.setVisible(true);
    	pseudo =frame.pseudo();
		//Client client = new Client();
        //System.out.println("Veuillez choisir un pseudo : ");
        //String pseudo= userInput.nextLine().trim();
        System.out.println("Pseudo choisi : " + pseudo);
        fram = new InterfaceChat();
    	fram.setVisible(true);
       
        try{
        
            Socket connexion = new Socket("localhost", 8888);
            Thread t = new Thread(new RunnableClient(connexion));
            t.start();
            System.out.println("Connecté au serveur...");
            
            output = connexion.getOutputStream();
            
            //envoi pseudo
            output.write(pseudo.getBytes());
            
            while(true){
                //bytes =userInput.nextLine().getBytes();
            	message=fram.ecrire();
            	bytes=message.getBytes();
                output.write(bytes);
                message="";
            }
            
            //gestion connexion : demander pseudo et attendre vérification
            
            //boucle réception/envoi messages
        }
        catch(IOException e){e.printStackTrace();}
            
    }
    
}
