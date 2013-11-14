
package projecte_prop;

/**
 *
 * @author pol
 */
import java.util.Date;


public class Solution {
    private int id;
    private String nom;
    Tour tour;
    Date fecha;
   

    public Solution(int id, String nom){
        fecha = new Date ();
        this.id = id;
        this.nom = nom;
        tour = new Tour();
    }
    
    public Tour getTour(){
        return tour;
    }
    
    public void addTour(Tour tour){
        this.tour = tour;
    }
    
    public int getid(){
        return id;
    }
    
    public String getNom(){
        return nom;
    }
    
    public int getCostSolution(){
       return tour.getCost();
    }
    
    public String getData(){
       return (fecha.toString());   
    }
    
}
