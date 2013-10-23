/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sa;

/**
 *
 * @author Carlos
 */

public class Adreça {
    int x;
    int y;
    int id;
    // Crea una nova adreça amb valors random
    public Adreça(){
        this.x = (int)(Math.random()*200);
        this.y = (int)(Math.random()*200);
    }
    
    // Crea una adreça donada dos valors
    public Adreça(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    // Gets address's x coordinate
    public int getX(){
        return this.x;
    }
    
    // Gets address's y coordinate
    public int getY(){
        return this.y;
    }
    
    // Gets the distance to given address
    public double distanceTo(Adreça address){
        int xDistance = Math.abs(getX() - address.getX());
        int yDistance = Math.abs(getY() - address.getY());
        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );
        
        return distance;
    }
    
    @Override
    public String toString(){
        return getX()+", "+getY();
    }

    public void afegir_id(int iden){
        id=iden;
    }
  
    public void afegir_id_random(){
       id=(int)Math.random()*10;
    }
 
    
}