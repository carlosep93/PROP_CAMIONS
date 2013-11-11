
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package camio;


/**
 *
 * @author pol
 */

public final class Element {
    private int id;
    private boolean enabled;
   
   
    public Element() {
       id = assignarID();
       enabled=true;     
    }
    public int assignarID(){
        return getid();
    }
    
     public void newElement(int id,boolean enabled) {
       this.id = id;
       this.enabled=enabled;     
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
   public void modifyid(int id){
       this.id=id;
   }
    
    
    
}
