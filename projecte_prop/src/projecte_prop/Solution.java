
package projecte_prop;

import java.util.Date;

public class Solution extends Tour {
    int id;
    String nom; //El nom de la solució serà el nom de la ciutat-sol_i
    Date fecha;

    public Solution(int id, String nom){
        super();
        fecha = new Date ();
        this.id = id;
        this.nom = nom;
    }
    
    public int getid(){
        return id;
    }
    
    public String getNom(){
        return nom;
    }
    
    public String getData(){
       return (fecha.toString());
    }
    
    public void addTour(Tour t){
        for(int i = 0; i < t.size(); ++i){
            super.addElement(t.getElementPos(i));
        }
    }
    
    
    
}