/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Drivers_class;
/**
 *
 * @author joanbarrosogarrido
 */
import projecte_prop.CjtTours;
import projecte_prop.Tour;
import java.util.Scanner;


public class DriverClass_CjtTours {
    
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int opt = 0;
            boolean opt1fet = false;
            System.out.println("Tria una mida del Cjt de Tours:");
            int size = sc.nextInt();
            CjtTours ct =  new CjtTours(size);
            while (opt != 10) {
                System.out.println();
                System.out.println("tria una opcio:");
                System.out.println("2 - Afegir un nou tour al conjunt"); 
                System.out.println("3 - Seleccionar un Tour");
                System.out.println("4 - Obtenir el tour amb menor cost");
                System.out.println("5 - Obtenir el cost d'un Tour");
                System.out.println("6 - Obtenir el cost de la ruta mes optima");
                System.out.println("7 - copiar un tour en un altre possició del conjunt de tours");
                System.out.println("8 - Swap de dos tours");
                System.out.println("9 - Consultar el tamany del conjunt");
                System.out.println("10 - Sortir");
                
                opt = sc.nextInt();
                System.out.println("Has escollit " + opt);
                
                
                if (opt == 2) {
                    System.out.println("Indica una possició, i li passem un Tour random");
                    int pos = sc.nextInt();
                    Tour T = new Tour();
                    ct.addTour(pos, T);
                    System.out.println("Lo ideal seria que ara que hi ha per lo menys un tour al conjunt, s'accedis amb el pas 3");
                  
                }
                
                 else if (opt == 3) {
                    System.out.println("indica l'id (posicio) del Tour");
                    int pos = sc.nextInt();
                    Tour T = ct.getTour(pos);
                    System.out.println("per saber si es el correcte, et retorno el seu cost!");
                    int cost = T.getCost();
                    System.out.println("el seu cost es" + cost);
                }
                 
                 else if (opt == 4) {
                    System.out.println("Es retorna un tour (fittest)");
                    Tour T;
                    T = ct.getFittestTour();
                    int cost = T.getCost();
                    System.out.println("es retorna el cost del Tour, per veure que es el millor:" + cost);
                    for (int i = 0; i < ct.sizeCjtTours(); ++i) {
                        cost = ct.getTour(i).getCost();
                        System.out.println("El cost del tour" + i + "es " + cost);
                    }
                }
            
                else if (opt == 5) {
                    System.out.println("indica posicio del tour del que vols el cost");
                    int pos = sc.nextInt();
                    int cost = ct.getTour(pos).getCost();
                    System.out.println("el cost es " + cost);
                }
                else if (opt == 6) {
                    int fit = ct.getFitness();
                    System.out.println("El cost del tour mes optim és:" + fit);
                }
                  
                else if (opt == 7) {
                    System.out.println("indica les posicions dels dos Tours que vols clonar (el segon en el primer)");
                    int pos1 = sc.nextInt();
                    int pos2 = sc.nextInt();
                    int cost = ct.getTour(pos1).getCost();
                    System.out.println("Primer de tot veurem els costos dels tours, i despres de copiarlos un altre cop, aixi veurem si tot ha anat bé");
                    System.out.println("el cost del tour de la posicio 1 es:" +cost);
                    cost = ct.getTour(pos2).getCost();
                    System.out.println("el cost del tour de la posicio 2 es:" + cost);
                    System.out.println();
                    ct.copyTour(pos1,pos2);
                    System.out.println("Ara els dos tours son iguals");
                    cost = ct.getTour(pos1).getCost();
                    System.out.println("El cost del primer Tour es:" + cost);
                    cost = ct.getTour(pos2).getCost();
                    System.out.println("el cost del segon tour es:" + cost);
                    
                }
                else if (opt == 8) {
                    System.out.println("Entra la possicio de cjt de tours on es troben els dos tours a fer swap");
                    int pos1 = sc.nextInt();
                    int pos2 = sc.nextInt();
                    System.out.println("Primer de tot veurem els costos dels tours, i despres de fer swap, un altre cop, aixi veurem si tot ha anat bé");
                    int cost = ct.getTour(pos1).getCost();
                    System.out.println("el cost del primer tour es:" + cost);
                    cost = ct.getTour(pos2).getCost();
                    System.out.println("el cost del segon tour es" + cost);
                    System.out.println("fem el swap");
                    ct.swapTours(pos1,pos2);
                    cost = ct.getTour(pos1).getCost();
                    System.out.println("El cost del tou que ara es a al posicio primera, és" + cost);
                    cost = ct.getTour(pos2).getCost();
                    System.out.println("El cost del tour de que ara es a la segona posició és" + cost);
                }
                else if (opt == 9) {
                    int s = ct.sizeCjtTours();
                    System.out.println("El tamany del conjunt és:" + s);
                }
            } 
        }
}
