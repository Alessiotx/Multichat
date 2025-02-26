/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.multichat;
import java.net.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author Alessio
 */
public class MultichatServer {
     public static void main(String[] args) throws IOException{
        boolean attivo = true;
        byte[] bufferOUT = new byte[1024];
        int conta = 20;
        int porta = 6789;
        InetAddress gruppo = InetAddress.getByName("225.4.5.6");
       
        MulticastSocket socket = new MulticastSocket();
       
        String dString = null;
        
        while(attivo){
            //come messaggio viene inviata la data e l'ora di sistema
            dString=new Date().toString();
            bufferOUT=dString.getBytes();
            //creo il datagramPacket
            DatagramPacket packet;
            packet = new DatagramPacket ( bufferOUT, bufferOUT.length, gruppo, porta);
            //invio il dato
            socket.send(packet);
                    
            //intuduco il ciclo di attesa di 1 secondo
            try{
                Thread.sleep(1000);
            } catch (InterruptedException ie){
                ie.printStackTrace();
            }
            conta--;
            if(conta==0){
                System.out.println("SERVER IN CHIUSURA. Buona serata.");
                attivo=false;
            }else{
                System.out.println("SERVER attivo per altri secondi "+ conta );
            }
            
        }
        socket.close();
    }
}
