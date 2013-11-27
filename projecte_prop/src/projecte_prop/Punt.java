
package projecte_prop;

public class Punt extends Element {
    private int x, y;
    String nom;
        
    public Punt(int x, int y, String nom){
        super();
        this.x = x;
        this.y = y;
        this.nom = nom;
    }
    
    public Punt(int id){
        super(id);
    }
        
    public int getX(){
        return x;
    }
        
    public int getY(){
        return y;
    }
    
    public String getNom(){
        return nom;
    }
    
}