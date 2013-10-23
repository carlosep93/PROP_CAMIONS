/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sa;

/**
 *
 * @author Carlos2
 */
import java.util.ArrayList;
import java.util.Collections;

public class Tour{

    // Holds our tour of cities
    private ArrayList tour = new ArrayList();
    // Cache
    private int distance = 0;
  
    // Constructs a blank tour
    public Tour(){
        for (int i = 0; i < TourManager.numberOfAdreces(); i++) {
            tour.add(null);
        }
    }
    
    // Constructs a tour from another tour
    public Tour(ArrayList tour){
        this.tour = (ArrayList) tour.clone();
    }
    
    // Returns tour information
    public ArrayList getTour(){
        return tour;
    }

    // Creates a random individual
    public void generateIndividual() {
        // Loop through all our destination address and add them to our tour
        for (int addressIndex = 0; addressIndex < TourManager.numberOfAdreces(); addressIndex++) {
          setAdreça(addressIndex, TourManager.getAdreça(addressIndex));
        }
        // Randomly reorder the tour
        Collections.shuffle(tour);
    }

    // Gets a address from the tour
    public Adreça getAdreça(int tourPosition) {
        return (Adreça)tour.get(tourPosition);
    }

    // Sets a city in a certain position within a tour
    public void setAdreça(int tourPosition, Adreça address) {
        tour.set(tourPosition, address);
        // If the tours been altered we need to reset the fitness and distance
        distance = 0;
    }
    
    // Gets the total distance of the tour
    public int getDistance(){
        if (distance == 0) {
            int tourDistance = 0;
            // Loop through our tour's cities
            for (int addressIndex=0; addressIndex < tourSize(); addressIndex++) {
                // Get city we're traveling from
                Adreça fromaddress = getAdreça(addressIndex);
                // Adreça we're traveling to
                Adreça destinationAddress;
                // Check we're not on our tour's last city, if we are set our 
                // tour's final destination city to our starting city
                if(addressIndex+1 < tourSize()){
                    destinationAddress = getAdreça(addressIndex+1);
                }
                else{
                    destinationAddress = getAdreça(0);
                }
                // Get the distance between the two cities
                tourDistance += fromaddress.distanceTo(destinationAddress);
            }
            distance = tourDistance;
        }
        return distance;
    }

    // Get number of cities on our tour
    public int tourSize() {
        return tour.size();
    }
    
    @Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < tourSize(); i++) {
            geneString += getAdreça(i)+"|";
        }
        return geneString;
    }
    
   
    
    
   

    
 public int escriu_ruta(){
     int mida = tour.size();
     System.out.println("la ruta final es:");
        for(int i = 0; i < mida ; ++i){
             Adreça adr = getAdreça(i);
            System.out.println(" "+ adr.id );
        }
        return 0;    
 }
 
 public void representar_tour(){
     char matriz[][] = new char[200][200];
     for (int x=0; x < 200; x++) {
         for (int y=0; y < 200; y++) matriz[x][y]= '.';
     }
    
     for (int i=0; i < tour.size()-1 ; ++i){
         Adreça a_inici = getAdreça(i);
         Adreça a_desti = getAdreça (i+1);
        
         int x1 = a_inici.x;
         int x2 = a_desti.x;
         int y1 = a_inici.y;
         int y2 = a_desti.y;
        
          
         matriz[x1-1][y1-1]= (char)a_inici.id;
       
         if(x1 > x2){
            int aux = x1;
            x1=x2;
            x2=aux;
        }
         if(y1 > y2){
          int aux = y1;
          y1=y2;
          y2=aux;
        }
        for (int y = y1; y < y2 ; y++) matriz[x1-1][y-1] = '-'; 
        for (int x = x1; x < x2 ; x++){
            if (matriz[x][y2-1] == '-') matriz[x][y2-1] = '+';
            else matriz[x][y2-1] = '|'; 
            
              
        }      
     }
     //Print de la matriu 
     for (int x=0; x < 200; x++) {
             for (int y=0; y < 200; y++) System.out.print(matriz[x][y]);
             System.out.println( );
         }    
   }
}
