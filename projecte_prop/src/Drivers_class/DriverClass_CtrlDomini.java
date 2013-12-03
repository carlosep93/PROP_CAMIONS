
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
                int x = 0;                      //int x = sc.nextInt();
                //System.out.println("Y:");
                int y = 0;                      //int y = sc.nextInt();
                
                ArrayList<String> nomsAct = Ctrl.getCity().getEnabled();
                ArrayList<Integer> pesosAct = new ArrayList<Integer>();
                for(int i = 0; i < nomsAct.size(); ++i){
                    System.out.println("Pes de l'element " + nom + " a l'element " + nomsAct.get(i));
                    pesosAct.add(sc.nextInt());
                }
                
                Ctrl.addPunt(nom, x, y, pesosAct);
                
                escriureCity(Ctrl.getCity());
            }
            else if(lectura == 2){
                System.out.println("Nom:");
                String nom = sc.nextLine();
                
                //no fa res....
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
                  System.out.println("Ubuntu(1) o windows(2) o definir path(3) ?");
                  int auxx = sc.nextInt();
                  if(auxx == 2) pathload = "src\\Fitxers\\";
                  else if(auxx == 3) pathload = sc.next();

                  System.out.println("Quin fitxer vols?");
                  String aux = sc.next();
                  pathload = pathload+aux;
                  //Relations rela = new Relations (Gestor_Dades.carregar_adjacencies(pathload)); 

                  //Ctrl.modificarRelationsCity(rela);
             } 
            
            
            else if(lectura == 6){
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
                    InitialSolGenerator isg = new InitialSolGenerator_Random();
                    Mutate mut = new Mutate_Little();
                    double SwapProbability, SwapRate;
                    SwapProbability = SwapRate = 0;
                    if(!predef){
                        System.out.println("Nom de la solucio:");
                        sc.nextLine();
                        nom = sc.nextLine();
                        
                        System.out.println("ID de la solucio:");
                        id = sc.nextInt();
                        
                        System.out.println("Creació de la solucio inicial(1-Random/ 2-TwoAPP:");
                        int inicial = sc.nextInt();
                        if(inicial == 1) isg = new InitialSolGenerator_Random();
                        else isg = new InitialSolGenerator_TwoApp();


                        System.out.println("Temperatura inicial (recomanat:1000) : ");
                        tmp = sc.nextDouble();

                        System.out.println("factor de pèrdua de temp: (recomanat: 0.03) :");
                        fact = sc.nextDouble();


                        System.out.println("parada: (recomanat: 25) ");
                        par = sc.nextInt();
                        
                        System.out.println("Tipus de mutació (1- Liitle//2- Rate//3- SwapRate:");
                        int mutacio = sc.nextInt();
                        if(mutacio == 1) mut = new Mutate_Little();
                        else if(mutacio == 2){
                            System.out.println("swap rate: ");
                            SwapRate = sc.nextInt();
                        }
                        else if(mutacio == 3){
                            System.out.println("swap rate: ");
                            SwapRate = sc.nextInt();
                            
                            System.out.println("swap probability: ");
                            SwapProbability = sc.nextInt();
                        }
                        
                    }
                    int aux = 0;
                    boolean aux2 = false;
                    
                    
                    Tsp_SA tsp = new Tsp_SA();
                    //Ctrl.tsp(nom, tsp, aux, aux, aux,
                    //        isg, aux2, null, aux,
                    //        null, mut, SwapRate, SwapProbability,
                    //        id, tmp, fact, par);
                }
                else{
                    String nom = "Sense_nom";
                    int id = 0;
                    InitialSolGenerator isg = new InitialSolGenerator_Random();
                    int StopCondition = 20;
                    int Ngeneracions = 1000;
                    int NTours = 50;
                    boolean Elitism = true;
                    TournamentSelection TS = new TournamentSelection_RouletteWheel();
                    int TournamentSize = 5;

                    Crossover cross = new Crossover_Simple();
                    Mutate mut = new Mutate_Rate();
                    double MutationRate = 0.15;
                    double MutationSwapProbability = 0.9;
                    
                    if(!predef){
                        System.out.println("Nom de la solucio:");
                        sc.nextLine();
                        nom = sc.nextLine();
                        
                        System.out.println("Id de la solucio:");
                        id = sc.nextInt();
                        
                        System.out.println("Creació de la solucio inicial(1-Random/ 2-TwoAPP:");
                        int inicial = sc.nextInt();
                        if(inicial == 1) isg = new InitialSolGenerator_Random();
                        else isg = new InitialSolGenerator_TwoApp();
                        
                        System.out.println("StopCondition: (recomanat: 20) ");
                        StopCondition = sc.nextInt();

                        System.out.println("NGeneracions: (recomanat: 1000)");
                        Ngeneracions = sc.nextInt();

                        System.out.println("NTours: (recomanat: 50)");
                        NTours = sc.nextInt();

                        System.out.println("Elitism: (recomanat: true )");
                        Elitism = sc.nextBoolean();

                        System.out.println("Tournament Selection: (1- Random/ 2- RouletteWheel) ");
                        int Roule = sc.nextInt();
                            
                        if(Roule == 1){
                            TS = new TournamentSelection_Random();
                            System.out.println("Tournament Size:");
                            TournamentSize = sc.nextInt();
                        }
                        else{
                            TS = new TournamentSelection_RouletteWheel();
                        }

                        System.out.println("Crossover: (1- Simple/ 2- Edge)");
                        int crossover = sc.nextInt();
                        if(crossover == 1){
                            cross = new Crossover_Simple();
                        }
                        else cross = new Crossover_Edge();


                        System.out.println("Mutate2: (1- Rate/ 2-RateSwap / 3-Little)");
                        int mutate = sc.nextInt();
                        
                        if(mutate == 1){
                            mut = new Mutate_Rate();
                            System.out.println("MutationRate: (recomanat: 0.015)");
                            MutationRate = sc.nextDouble();
                        }
                        else if(mutate == 2){
                            mut = new Mutate_SwapRate();
                            
                            System.out.println("MutationRate: (recomanat: 0.015)");
                            MutationRate = sc.nextDouble();
                            
                            System.out.println("MutationSwapProbability: (recomanat: 0.9)");
                            MutationSwapProbability = sc.nextDouble();
                        }
                        else mut = new Mutate_Little();
                    }
                    
                    double aux = 0;
                    int aux2 = 0;
                    
                    Tsp_GA tsp = new Tsp_GA();
                    //Ctrl.tsp(nom, tsp, StopCondition, Ngeneracions, NTours,
                    //        isg, Elitism, TS, TournamentSize, 
                    //        cross, mut, MutationRate, MutationSwapProbability,
                    //        id, aux, aux, aux2);
               
                }
                escriureSolucio(Ctrl);
            }
            System.out.println();
        }
    }
        
    
    public static void escriureCity(City ciutat){
        ArrayList<Punt> Pts = ciutat.getPunts();
        System.out.println("Printo els punts:");
        for(int i = 0; i < Pts.size(); ++i){
            System.out.println(Pts.get(i).getNom() + "    ");
        }
        System.out.println();
        
        ArrayList<ArrayList<Integer>> adj = ciutat.getAdjacency();
        System.out.println("Printo les adjacencies:");
        for(int i = 0; i < adj.size(); ++i){
            for(int ii = 0; ii < adj.get(0).size(); ++ii){
                System.out.print(adj.get(i).get(ii) + "    ");
            }
            System.out.println();
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
            System.out.print(" " + sol.getElementPos(i).getNom());
          if(i%10==0)  System.out.println();
        }
         System.out.println();
         System.out.println("Cost = " + sol.getCost(Ctrl.getCity()));
         System.out.println();
    }
}
