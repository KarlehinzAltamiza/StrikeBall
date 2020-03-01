/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strikeball;

/**
 *
 * @author acqua
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class CreaServerSocket {

  /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        int porta = 3500;
        int tempo = 10;
        //creare il server
        try {
            ServerSocket ss = new ServerSocket(porta);
            while(true){
                System.out.println("in attesa di connessioni");
                Socket s= ss.accept();
                s.setSoTimeout(10*1000);
                System.out.println("tempo:"+s.getSoTimeout());
                System.out.println("connessione stablita");
                
		Scanner	in= new	Scanner(s.getInputStream());
                PrintWriter out	= new PrintWriter(s.getOutputStream()); 
                String line = in.nextLine(); 
                out.println("Received:ù" +line); 																
                out.flush();
                s.close();
                System.out.println("connessione chiusa");
                }
        } catch (BindException i){
            System.err.println("il server socket e gia in esecuzione");
        }
        catch (IOException e){
            e.printStackTrace(); //ti fa visualizzare la traccia dell'errore
        }
    }
}
