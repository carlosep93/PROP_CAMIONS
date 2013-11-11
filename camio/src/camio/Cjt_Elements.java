
 
package camio;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
*/

/**
 *
 * @author pol
 */
public final class Cjt_Elements { //conjunt d'elements guardats a disc
    List<Element> cjt_elements; 
    int[][] distancies; 
    int Id_global_element=0;
    int numElem;
    
    /**
     *
     */
    public Cjt_Elements (){ 
        cjt_elements = saved_elements();
        numElem=cjt_elements.size();
       // distancies = cjt_adjacencies();
        
        
    }
    
    
    
    public List<Element> saved_elements(){
        List<Element> saved_elements = new List<Element>(); 
        Element elem = new Element();
        try{
        //obrir arxiu
        FileInputStream llegir = new FileInputStream("Ficheros/saved_elements.txt");
        //creem objecte entrada
        DataInputStream entrada = new DataInputStream(llegir);
        //creem buffer de lectura
        BufferedReader buffer = new BufferedReader (new InputStreamReader(entrada));
        
        String strLinea;
        int i=0;
        int id_elem= -1;
        boolean active;
        while ((strLinea = buffer.readLine()) != null){
            if(i%2==0) id_elem = Integer.parseInt(strLinea); // si es un int
            if (i%2==1){
                  active = ("true".equals(strLinea)); 
                  elem.newElement(id_elem,active);
                  saved_elements.add(elem);
            }
            ++i;
        }
        //tanquem en arxiu
        entrada.close();
    }catch (Exception e){
        System.err.println("Error desconegut " + e.getMessage());
    }

    return saved_elements;
    }

/*-------------------------------IMPLEMENTANT-----------------------------*/    
    
    public int[][] cjt_adjacencies(){
        
        int[][] adjacencies = new int[numElem][numElem];
        try{
        FileInputStream llegir = new FileInputStream("Ficheros/saved_adjacencys.txt");
        DataInputStream entrada = new DataInputStream(llegir);
        BufferedReader buffer = new BufferedReader (new InputStreamReader(entrada));
       
        FileInputStream llegir2 = new FileInputStream("Ficheros/saved_elements.txt");
        DataInputStream entrada2 = new DataInputStream(llegir2);
        BufferedReader buffer2 = new BufferedReader (new InputStreamReader(entrada2));
        
          String strLinea;
          int i=0;
          int id_elem;
        while ((strLinea = buffer.readLine()) != null){
            if(i%2==0){
                id_elem = Integer.parseInt(strLinea);          
            }
            if (i%2==1){
                int proper;
             while((proper = buffer.readInt() )!=null){
                 
             }
            }
            ++i;
        }
        //tanquem en arxiu
     entrada.close();
    }catch (Exception e){
        System.err.println("Error desconegut " + e.getMessage());
    }
    
        return adjacencies;   
    
}
    
    
     public int getid(){
        int id=Id_global_element;   //L' ID_GLOBAL s'ha de definir al controlador
        ++Id_global_element;
        return id;       
    }
}





