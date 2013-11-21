
package projecte_prop;

/**
 *
 * @author pol
 */
import java.util.Date;
import static Controladors.CtrlDomini.*;

public class Solution {
    int id;
    String nom;  //El nom de la solució serà el nom de la ciutat-sol_i
    Tour tour;
    Date fecha;
    int cost;

    public Solution (int id){
        fecha = new Date ();
        this.id = id;
        nom = "Sense_Nom";
        tour = new Tour();
        cost = -1;
    }
    public Solution(int id, String nom){
        fecha = new Date ();
        this.id = id;
        this.nom = nom;
        tour = new Tour();
        cost = -1;
    }
    public Solution(int id, String nom, int cost){
        fecha = new Date ();
        this.id = id;
        this.nom = nom;
        this.cost = cost;
        tour = new Tour();
        
    }
    
    public Tour getTour(){
        return tour;
    }
    
    public void addTour(Tour tour){
        this.tour = tour;
    }
    
    public void addCost(int cost){
        this.cost = cost;
    }
    
    public int getid(){
        return id;
    }
    
    public String getNom(){
        return nom;
    }
    
    public int getCostSolution(){
       return cost;
    }
    
    public String getData(){
       return (fecha.toString());   
    }
    
}
