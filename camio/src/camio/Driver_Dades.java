import java.io.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package camio;

/**
 *
 * @author pol
 */
public class Driver_Dades {  //mirar la funció scanner
    
    try{
    //obrir arxiu
    FileInputStream llegir = new FileInputStream("SRC/nomtext.txt");
    //creem objecte entrada
    DataInputStream entrada = new DataInputStream(llegir);
    //creem buffer de lectura
    BufferedReader buffer = new BufferedReader (new InputStreamReader(entrada));
    String strLinea;
    int count =0;
    while ((strLinea = buffer.readLine()) != null){
        if/count ==0) nom=strLinea; // si es un string
        else if (count ==1) temps = Integer.parseInt(strLinea); //si és un int
    
    
}
    //tanquem en arxiu
    entrada.close();
}catch (Exception e){
    System.err.println("Error desconegut " + e.getMessage());
}
    
}
