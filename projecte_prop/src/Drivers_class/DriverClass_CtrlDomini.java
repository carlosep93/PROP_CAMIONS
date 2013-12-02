
package Drivers_class;
/**
 *
 * @author josep
 */


import Controladors.CtrlDomini;
import projecte_prop.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import Gestor_de_Dades.Gestor_Dades;

public class DriverClass_CtrlDomini {
    
        public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String pathload = "src/Fitxers/";

        CtrlDomini Ctrl = new CtrlDomini("primer");

        
        int lectura = 0;
        while(lectura != 7){   
            System.out.println();
            System.out.println("Tria una opció:");
            System.out.println("1 - Afegir Punt");
            System.out.println("2 - Consultar Punt");
            System.out.println("3 - Modificar Punt");
            System.out.println("4 - Eliminar Punt");
            System.out.println("5 - Carregar adjacencies de Memoria");
            System.out.println("6 - Generar Camí");
            System.out.println("7 - Sortir");

 
            lectura=sc.nextInt();


            if(lectura == 1){                
                System.out.println("Nom:");
                sc.nextLine();
                String nom = sc.nextLine();
                
                //System.out.println("X:");
                int x = 0;          //int x = sc.nextInt();
                //System.out.println("Y:");
                int y = 0;                    //int y = sc.nextInt();
                
                Ctrl.
                
                escriureCjtElem(Ctrl, Ctrl.getCjtElement());
                escriureRelations(Ctrl, Ctrl.getRelations());
            }
            else if(lectura == 2){
               /* System.out.println("Nom:");
                String nom = sc.nextLine();
                
                CtrlDomini.consultaElement(nom);*/
            }
            /*
            else if(lectura == 3){
                int id = CtrlDomini.getnewID();
                
                System.out.println("Nom:");
                String nom = sc.nextLine();
                
                System.out.println("X:");
                int x = sc.nextInt();
                System.out.println("Y:");
                int y = sc.nextInt();
                
                System.out.println("enabled:");
                boolean enabled = sc.nextBoolean();
                
                Element E = new Element(id, nom, x, y, enabled);
                
                System.out.println("Nom:");
                nom = sc.nextLine();
                
                CtrlDomini.modificaElement(E, nom);
            }
            else if(lectura == 4){
                System.out.println("Nom:");
                sc.nextLine();
                String nom = sc.nextLine();
                
                Ctrl.eliminaElement(nom);
                
                escriureCjtElem(Ctrl, Ctrl.getCjtElement());
                escriureRelations(Ctrl, Ctrl.getRelations());
            }
*/
             else if(lectura == 5){
               System.out.println("NO FAIG REEEES");  
             }
                  

             else if(lectura == 6){
                  System.out.println("Ubuntu(1) o windows(2) o definir path(3) ?");
                  int auxx = sc.nextInt();
                  if(auxx == 2) pathload = "src\\Fitxers\\";
                  else if(auxx == 3) pathload = sc.next();

                  System.out.println("Quin fitxer vols?");
                  String aux = sc.next();
                  pathload = pathload+aux;
                  Relations rela = new Relations (Gestor_Dades.carregar_adjacencies(pathload)); 

                  Ctrl.modificarRelationsCity(rela);
             } 
            
            
            else if(lectura == 7){
                System.out.println("1, SistemAnnealing// 2, GeneticAlgorithm:");
                int alg = sc.nextInt();
                System.out.println("Vols usar els paràmetres predefinits? (true / false) ");
                boolean predef = sc.nextBoolean();

               
               
               
                if(alg == 1){
                    String nom = "sense_nom";
                    int id = 0;
                    double tmp = 1000;
                    double fact = 0.03;
                    int par = 25;
                    if(!predef){
                        System.out.println("Nom de la solucio:");
                        sc.nextLine();
                        nom = sc.nextLine();
                        
                        System.out.println("ID de la solucio:");
                        id = sc.nextInt();


                        System.out.println("Temperatura inicial (recomanat:1000) : ");
                        tmp = sc.nextDouble();

                        System.out.println("factor de pèrdua de temp: (recomanat: 0.03) :");
                        fact = sc.nextDouble();


                        System.out.println("parada: (recomanat: 25) ");
                        par = sc.nextInt();
                        }
                    Ctrl.tspSA(nom, tmp, fact, par, id);                    
                }
                else{

                    String nom = "Sense_nom";
                    int id = 0;
                    int StopCondition = 20;
                    int Ngeneracions = 1000;
                    int NTours = 50;
                    boolean Elitism = true;
                    boolean RouletteWheel_TS = true;
                    int TournamentSize = 0;

                    boolean Edge_crossover = true;
                    boolean Mutate2 = true;
                    double MutationRate = 0.15;
                    double MutationSwapProbability = 0.9;
                    
                    if(!predef){
                        System.out.println("Nom de la solucio:");
                        sc.nextLine();
                        nom = sc.nextLine();
                        
                        System.out.println("Id de la solucio:");
                        id = sc.nextInt();
                        
                        System.out.println("StopCondition: (recomanat: 20) ");
                        StopCondition = sc.nextInt();

                        System.out.println("NGeneracions: (recomanat: 1000)");
                        Ngeneracions = sc.nextInt();

                        System.out.println("NTours: (recomanat: 50)");
                        NTours = sc.nextInt();

                        System.out.println("Elitism: (recomanat: true )");
                        Elitism = sc.nextBoolean();

                        System.out.println("RouletteWheel_TS: (Recomanat: true) ");
                        RouletteWheel_TS = sc.nextBoolean();

                        if(!RouletteWheel_TS){
                          System.out.println("TournamentSize: (recomanat: 2)");
                            TournamentSize = sc.nextInt();
                        }

                        System.out.println("Edge_crossover: (recomanat: true)");
                        Edge_crossover = sc.nextBoolean();

                        System.out.println("Mutate2: (recomanat: true)");
                        Mutate2 = sc.nextBoolean();

                        System.out.println("MutationRate: (recomanat: 0.015)");
                         MutationRate = sc.nextDouble();


                        if(Mutate2){
                           System.out.println("MutationSwapProbability: (recomanat: 0.9)");
                            MutationSwapProbability = sc.nextDouble();
                        }
                    }
                    
                     Ctrl.tspGA(nom, StopCondition, Ngeneracions, NTours, Elitism, RouletteWheel_TS,
                     TournamentSize, Edge_crossover, Mutate2, MutationRate, MutationSwapProbability, id);
               
                }
                escriureSolucio(Ctrl);
            }
            System.out.println();
        }
    }
        
    
    public static void escriureCjtElem(CtrlDomini Ctrl, Tour cjtElem){
        Tour t = Ctrl.getCity().get_Tour();
        for(int i = 0; i < t.size(); ++i){
            System.out.print(" " + t.getElementPos(i).getID());
        }
        System.out.println();
    }
    
    public static void escriureRelations(CtrlDomini Ctrl, Relations R){
        Relations r = Ctrl.getCity().get_Relations();
        for(int i = 0; i < r.size(); ++i){
            System.out.println(r.toString(i));
        }
        System.out.println();
    }
    
    public static void escriureSolucio(CtrlDomini Ctrl){
        Solution sol = Ctrl.getSolution();
        System.out.println("Nom solució: " + sol.getNom());
         System.out.println();
         System.out.println("L'ordre d'elements és: ");
         System.out.println();
        for(int i = 0; i < sol.size(); ++i){
            System.out.print(" " + sol.getElementPos(i).getID());
          if(i%10==0)  System.out.println();
        }
         System.out.println();
         System.out.println("Cost = " + sol.getCost(Ctrl.getCity()));
         System.out.println();
    }
}
