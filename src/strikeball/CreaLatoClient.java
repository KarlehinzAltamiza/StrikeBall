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
public class CreaLatoClient {
    public static void main(String[] args) {
        // TODO code application logic here
        String server ="localhost";
        int porta =3500;
        //creo connessione con il server
        try{
            Socket s=new Socket(server,porta);
            System.out.println("connessione aperta");  
            Scanner socketIn = new Scanner(s.getInputStream());
            PrintWriter socketOut = new PrintWriter(s.getOutputStream());
            Scanner stdin = new	Scanner(System.in); 
            String inputLine = stdin.nextLine(); 																
            socketOut.println(inputLine); 																
            socketOut.flush();
            String socketLine = socketIn.nextLine(); 																
            System.out.println(socketLine);
            s.close();
            System.out.println("connessione chiusa");
        }catch(IOException e){
            e.printStackTrace();//ti visulizza la traccia dell'errore
        }
    }
}

