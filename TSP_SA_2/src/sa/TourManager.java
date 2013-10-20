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

public class TourManager {

    // Holds our address
    private static ArrayList destinationAdreces = new ArrayList();

    // Adds a destination address
    public static void addAdreça(Adreça address) {
        destinationAdreces.add(address);
    }
    
    // Get a city
    public static Adreça getAdreça(int index){
        return (Adreça)destinationAdreces.get(index);
    }
    
    // Get the number of destination cities
    public static int numberOfAdreces(){
        return destinationAdreces.size();
    }
    
 

}