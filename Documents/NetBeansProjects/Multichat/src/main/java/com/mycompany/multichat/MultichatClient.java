/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.multichat;
import java.net.*;
import java.io.*;
/**
 *
 * @author Alessio
 */
public class MultichatClient {

    public static void main(String[] args)  throws IOException{
         byte[] bufferIN = new byte[1024];
    int porta = 6789;
    String gruppo = "225.4.5.6";
    //creazione socket sulla porta
        MulticastSocket socket = new MulticastSocket (porta); 
            socket.joinGroup(InetAddress.getByName(gruppo));
            
            DatagramPacket packetIN = new DatagramPacket(bufferIN,bufferIN.length);
            socket.receive(packetIN);
            
            System.out.println("Ho ricevuto dati di lunghezza: "+packetIN.getLength()+" da: "+packetIN.getAddress().toString()+" porta: "+packetIN.getPort());
            System.out.write(packetIN.getData(),0,packetIN.getLength());
            System.out.println();
            
            socket.leaveGroup(InetAddress.getByName(gruppo));
        socket.close();
    }
}
