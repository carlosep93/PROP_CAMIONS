
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte_prop;

/**
 *
 * @author pol
 */

public final class Element {
    private int id;
    private boolean enabled;
   
   
    public Element() {
       id = Cjt_Elements.Id_global_element;
       ++Cjt_Elements.Id_global_element;
       enabled=true;     
    }
   
     public Element(int id,boolean enabled) {
       this.id = id;
       this.enabled=enabled;     
    }
    public Element(int id){
     this.id = id;   
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
