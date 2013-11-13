
 
package projecte_prop;

import java.util.List;
import java.util.ArrayList;
import java.io.*;



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
    static int Id_global_element=0;
    int numElem;
    
    /**
     *
     */
    public Cjt_Elements (){ 
        cjt_elements = saved_elements();
        numElem=cjt_elements.size();
       // distancies = cjt_adjacencies();
        
        
    }
    
    
    
    public List<Element> saved_elements(){  //Retorna la llista d'elements guardats
        List<Element> saved_elements = new ArrayList<Element>() ; 
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

    
    public void save_Element(Element elem){   //guardem un element al conjunt d'elements
        
        FileWriter fichero = null;
        PrintWriter pw;
        try
        {
            fichero = new FileWriter("Ficheros/saved_elements.txt");
            pw = new PrintWriter(fichero);
            int id_elem = elem.getID();
            String valid = "false";
            if (elem.isEnabled()) valid="true";
            pw.println(id_elem);
            pw.println(valid);
 
        } catch (Exception e) {
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
           }
        }
    }
    
    public void discatalogue_Element(Element elem){  //invalida un element
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("Ficheros/saved_elements.txt");
            pw = new PrintWriter(fichero);
           
            int id_elem = elem.getID();
            int id_llegit;
           // while();
 
        } catch (Exception e) {
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
           }
        }
    
    }
    
    
/*-------------------------------NO_IMPLEMENTAT-----------------------------*/    
  /*  
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
    
    */
     public int getid(){
        int id=Id_global_element;   //L' ID_GLOBAL s'ha de definir al controlador
        ++Id_global_element;
        return id;       
    }
}





