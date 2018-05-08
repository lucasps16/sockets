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

/**
 *
 * @author Estudiante
 */
public class Cliente {
    public static void main(String[] args) {
         try {
            
            Socket cliente = new Socket("localhost",8000);
            //Abrir FLujos
            InputStream flujoEntrada = cliente.getInputStream();
            OutputStream flujoSalida = cliente.getOutputStream();
            //Decoradores para leer la info.
            BufferedReader lectura = new BufferedReader(new InputStreamReader(flujoEntrada));
            BufferedReader lecturaUsuario = new BufferedReader(new InputStreamReader(System.in)); //Convierte bytes a caracteres
            PrintWriter escritura = new PrintWriter(flujoSalida,true);
            String mensajeLeido = "";
            String mensajeUsuario = "";
            System.out.println("Escriba su mensaje \n");
            while (true){                
                mensajeUsuario = lecturaUsuario.readLine();
                escritura.println(mensajeUsuario);
                
                mensajeLeido = lectura.readLine();
                
                System.out.println (mensajeLeido);
            }
            
            //Se cierran los flujos.
            //escritura.close();
            // lectura.closee();
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
