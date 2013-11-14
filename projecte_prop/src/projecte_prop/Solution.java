
package projecte_prop;

/**
 *
 * @author josep
 */
public class Solution {
    private int id;
    private String nom;
    Tour tour;
    
    public Solution(int id, String nom){
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
}
