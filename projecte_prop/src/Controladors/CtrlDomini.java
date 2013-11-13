/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladors;

/**
 *
 * @author pol
 */
public class CtrlDomini { //   Aquesta clase inicialitza les variables globals, estructures de dades...
    static String path_adjacencies =
   "C:\\Users\\helewt\\Documents\\GitHub\\PROP_CAMIONS\\projecte_prop\\src\\Fitxers\\saved_adjacencys.txt";
    static String path_elements =
   "C:\\Users\\helewt\\Documents\\GitHub\\PROP_CAMIONS\\projecte_prop\\src\\Fitxers\\saved_elements.txt";
    
    
    
    public void iniciarDomini(){
        
    }
    
    public void canviar_path_adjacencies(String path){
        path_adjacencies = path;
        
    }
     public void canviar_path_elements(String path){
        path_elements = path;
        
    }
}
