
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp_ga;

/**
 *
 * @author pol
 */

public class Element {
    private int id;
    private boolean enabled;
   
   
    public Element() {
       id = getid();
       enabled=true;     
    }
    
    private int getid(){
        int id=Id_global;   //L' ID_GLOBAL s'ha de definir al controlador
        ++Id_global;
        return id;       
    }
    
    
    public int getID(){
        return id;       
    }
    
    public boolean isEnabled(){
        return enabled;       
    }
    
    public void updateEnabled(boolean newvalue){
        enabled=newvalue;
    }
   
    
    
    
}
