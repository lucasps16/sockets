/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main(String[] args) {
        try {
            
            ServerSocket server = new ServerSocket(8000);
            System.out.println("Servidor en espera");
            Socket cliente = server.accept();
            System.out.println("Se ha conectado al servidor");
            //Abrir FLujos
            InputStream flujoEntrada = cliente.getInputStream();
            OutputStream flujoSalida = cliente.getOutputStream();
            //Decoradores para leer la info.
            BufferedReader lectura = new BufferedReader(new InputStreamReader(flujoEntrada)); //Convierte bytes a caracteres
            PrintWriter escritura = new PrintWriter(flujoSalida,true);
            BufferedReader lecturaServidor = new BufferedReader(new InputStreamReader(System.in));
            String mensajeLeido = "";
            String mensajeServidor = "";
            while (true){
                //Se recibe la info.
                mensajeLeido = lectura.readLine();
                System.out.println("Usuario: " + mensajeLeido);
                mensajeServidor = lecturaServidor.readLine();
                //Se responde la info.
                escritura.println("Servidor: Mamelo" + mensajeServidor);
            }
            
            //Se cierran los flujos.
            //escritura.close();
            // lectura.closee();
            
        } catch (IOException ex) {
        }
    }

}
