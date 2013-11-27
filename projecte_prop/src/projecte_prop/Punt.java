
package projecte_prop;

public class Punt extends Element {
    private int x, y;
        
    public Punt(int x, int y){
        super();
        this.x = x;
        this.y = y;
    }
        
    public int getX(){
        return x;
    }
        
    public int getY(){
        return y;
    }     
}