/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sa;

/**
 *
 * @author Carlos2
 */
public class SimulatedAnnealing {

    // Calculate the acceptance probability
    public static double acceptanceProbability(int engery, int newEngery, double temperature) {
        // If the new solution is better, accept it
        if (newEngery < engery) {
            return 1.0;
        }
        // If the new solution is worse, calculate an acceptance probability
        return Math.exp((engery - newEngery) / temperature);
    }

    public static void main(String[] args) {
        // Create and add our cities
        Adreça address = new Adreça(60, 200);
        address.afegir_id(1);
        TourManager.addAdreça(address);
        Adreça address2 = new Adreça(180, 200);
        address2.afegir_id(2);
        TourManager.addAdreça(address2);
        Adreça address3 = new Adreça(80, 180);
        address3.afegir_id(3);
        TourManager.addAdreça(address3);
        Adreça address4 = new Adreça(140, 180);
        address4.afegir_id(4);
        TourManager.addAdreça(address4);
        Adreça address5 = new Adreça(20, 160);
        address5.afegir_id(5);
        TourManager.addAdreça(address5);
        Adreça address6 = new Adreça(100, 160);
        address6.afegir_id(6);
        TourManager.addAdreça(address6);
        Adreça address7 = new Adreça(200, 160);
        address7.afegir_id(7);
        TourManager.addAdreça(address7);
        Adreça address8 = new Adreça(140, 140);
        address8.afegir_id(8);
        TourManager.addAdreça(address8);
        Adreça address9 = new Adreça(40, 120);
        address9.afegir_id(9);
        TourManager.addAdreça(address9);
        Adreça address10 = new Adreça(100, 120);
        address10.afegir_id(10);
        TourManager.addAdreça(address10);
        Adreça address11 = new Adreça(180, 100);
        address11.afegir_id(11);
        TourManager.addAdreça(address11);
        Adreça address12 = new Adreça(60, 80);
        address12.afegir_id(12);
        TourManager.addAdreça(address12);
        Adreça address13 = new Adreça(120, 80);
        address13.afegir_id(13);
        TourManager.addAdreça(address13);
        Adreça address14 = new Adreça(180, 60);
        address14.afegir_id(14);
        TourManager.addAdreça(address4);
        Adreça address15 = new Adreça(20, 40);
        address15.afegir_id(15);
        TourManager.addAdreça(address15);
        Adreça address16 = new Adreça(100, 40);
        address16.afegir_id(16);
        TourManager.addAdreça(address16);
        Adreça address17 = new Adreça(200, 40);
        address17.afegir_id(17);
        TourManager.addAdreça(address17);
        Adreça address18 = new Adreça(20, 20);
        address18.afegir_id(18);
        TourManager.addAdreça(address18);
        Adreça address19 = new Adreça(60, 20);
        address19.afegir_id(19);
        TourManager.addAdreça(address19);
        Adreça address20 = new Adreça(160, 20);
        address20.afegir_id(20);
        TourManager.addAdreça(address20);

        // Set initial temp
        double temp = 10000;

        // Cooling rate
        double coolingRate = 0.003;

        // Initialize intial solution
        Tour currentSolution = new Tour();
        currentSolution.generateIndividual();
         System.out.println("Initial solution distance: " + currentSolution.getDistance());

        // Set as current best
        Tour best = new Tour(currentSolution.getTour());
        
        // Loop until system has cooled
        while (temp > 1) {
            // Create new neighbour tour
            Tour newSolution = new Tour(currentSolution.getTour());

            // Get a random positions in the tour
            int tourPos1 = (int) (newSolution.tourSize() * Math.random());
            int tourPos2 = (int) (newSolution.tourSize() * Math.random());

            // Get the cities at selected positions in the tour
            Adreça AdreçaSwap1 = newSolution.getAdreça(tourPos1);
            Adreça AdreçaSwap2 = newSolution.getAdreça(tourPos2);

            // Swap them
            newSolution.setAdreça(tourPos2, AdreçaSwap1);
            newSolution.setAdreça(tourPos1, AdreçaSwap2);
            
            // Get energy of solutions
            int currentEngery = currentSolution.getDistance();
            int neighbourEngery = newSolution.getDistance();

            // Decide if we should accept the neighbour
            if (acceptanceProbability(currentEngery, neighbourEngery, temp) > Math.random()) {
                currentSolution = new Tour(newSolution.getTour());
            }

            // Keep track of the best solution found
            if (currentSolution.getDistance() < best.getDistance()) {
                best = new Tour(currentSolution.getTour());
            }
            
            // Cool system
            temp *= 1-coolingRate;
        }
        System.out.println("Final solution distance: " + best.getDistance());
        System.out.println(" " + best.escriu_ruta() );
        System.out.println("Tour: " + best);
        best.representar_tour();
    }
}