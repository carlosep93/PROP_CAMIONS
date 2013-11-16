
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte_prop;

import static Controladors.CtrlDomini.*;

/**
 *
 * @author pol
 */


public  class Element {
    private int id;
    private boolean enabled;
    private String nom;
    private int x, y;
   
   
    public Element() {
       id = getnewID();
       enabled=true;     
    }
    
    public Element(int id, String nom, int x, int y, boolean enabled) {
       this.id = id;
       this.nom = nom;
       this.x = x;
       this.y = y;
       this.enabled=enabled;     
    }

    
    public Element(int id){
     this.id = id;   
    }
    

    public int getID(){
        return id;       
    }
    
    public String getNom(){
        return nom;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public boolean isEnabled(){
        return enabled;       
    }
    
    public void modifyEnabled(boolean newvalue){
        enabled=newvalue;
    }
        
    public void modifyid(int id){
       this.id=id;
    }
}
