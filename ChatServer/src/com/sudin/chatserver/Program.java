/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sudin.chatserver;

import com.sudin.chatserver.handler.ClientHandler;
import com.sudin.chatserver.handler.ClientListner;
import com.sun.jmx.remote.internal.ClientListenerInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ranji
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int port =9000;
        try{
        ServerSocket server=new ServerSocket(port);
            System.out.println("server is running at port" +port);
            ClientHandler handler=new ClientHandler();
            handler.start();
        while(true){
            Socket client=server.accept();
           ClientListner listner=new ClientListner(client, handler);
           listner.start();
            System.out.println("connection request from" +client.getInetAddress().getHostAddress());
             
             
        }
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
    
}
