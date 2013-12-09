
package Drivers_class;
/**
 *
 * @author josep
 */


import Controladors.CtrlDomini;
import exception.ExceptionExistence;
import projecte_prop.*;
import java.util.Scanner;
import java.util.ArrayList;

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
                ArrayList<String> nomsAct = new ArrayList<String>();
                try{
                    nomsAct = Ctrl.getEnabled();
                }
                catch(ExceptionExistence e){
                    System.out.println(e.getMessage());
                }
                ArrayList<Integer> pesosAct = new ArrayList<Integer>();
                for(int i = 0; i < nomsAct.size(); ++i){
                    System.out.println("Pes de l'element " + nom + " a l'element " + nomsAct.get(i));
                    pesosAct.add(sc.nextInt());
                }
                try{
                    Ctrl.addPunt(nom, x, y, pesosAct);
                }
                catch(ExceptionExistence e){
                    System.out.println(e.getMessage());
                }
            }
            else if(lectura == 2){
                System.out.println("Nom:");
                sc.nextLine();
                String nom = sc.nextLine();
                
                try{
                    Integer[] pesos = Ctrl.consultaPunt(nom);
                }
                catch(ExceptionExistence e){
                    System.out.println(e.getMessage());
                }
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
                    int isg = 0;
                    double tmp = 1000;
                    double fact = 0.03;
                    int par = 25;
                    int mut = 3;
                    double SwapProbability, SwapRate;
                    SwapProbability = SwapRate = 0.015;
                    if(!predef){
                        System.out.println("Nom de la solucio:");
                        sc.nextLine();
                        nom = sc.nextLine();
                        
                        System.out.println("ID de la solucio:");
                        id = sc.nextInt();
                        
                        System.out.println("Creació de la solucio inicial(0-Random/ 1-TwoAPP:");
                        isg = sc.nextInt();

                        System.out.println("Temperatura inicial (recomanat:1000) : ");
                        tmp = sc.nextDouble();

                        System.out.println("factor de pèrdua de temp: (recomanat: 0.03) :");
                        fact = sc.nextDouble();


                        System.out.println("parada: (recomanat: 25) ");
                        par = sc.nextInt();
                        
                        System.out.println("Tipus de mutació (0- Rate//1- RateSwap//2- Little:");
                        mut = sc.nextInt();
                        if(mut == 1){
                            System.out.println("swap rate: ");
                            SwapRate = sc.nextDouble();
                        }
                        else if(mut == 2){
                            System.out.println("swap rate: ");
                            SwapRate = sc.nextDouble();
                            
                            System.out.println("swap probability: ");
                            SwapProbability = sc.nextDouble();
                        }
                    }
                    try{
                        Ctrl.tsp(nom, 0, 0, 0, 0,
                            isg, false, 0, 0,
                            0, mut, SwapRate, SwapProbability,
                            id, tmp, fact, par);
                    }
                    catch(ExceptionExistence e){
                        System.out.println(e.getMessage());
                    }
                }
                else{
                    String nom = "Sense_nom";
                    int id = 0;
                    int isg = 0;
                    int StopCondition = 20;
                    int Ngeneracions = 1000;
                    int NTours = 50;
                    boolean Elitism = true;
                    int TS = 0;
                    int TournamentSize = 5;

                    int cross = 0;
                    int mut = 0;
                    double MutationRate = 0.15;
                    double MutationSwapProbability = 0.9;
                    
                    if(!predef){
                        System.out.println("Nom de la solucio:");
                        sc.nextLine();
                        nom = sc.nextLine();
                        
                        System.out.println("Id de la solucio:");
                        id = sc.nextInt();
                        
                        System.out.println("Creació de la solucio inicial(0-Random/ 1-TwoAPP:");
                        isg = sc.nextInt();
                        
                        System.out.println("StopCondition: (recomanat: 20) ");
                        StopCondition = sc.nextInt();

                        System.out.println("NGeneracions: (recomanat: 1000)");
                        Ngeneracions = sc.nextInt();

                        System.out.println("NTours: (recomanat: 50)");
                        NTours = sc.nextInt();

                        System.out.println("Elitism: (recomanat: true )");
                        Elitism = sc.nextBoolean();

                        System.out.println("Tournament Selection: (0- Random/ 1- RouletteWheel) ");
                        TS = sc.nextInt();
                            
                        if(TS == 0){
                            System.out.println("Tournament Size:");
                            TournamentSize = sc.nextInt();
                        }

                        System.out.println("Crossover: (0- Simple/ 1- Edge)");
                        cross = sc.nextInt();

                        System.out.println("Mutate2: (0- Rate/ 1-RateSwap / 2-Little)");
                        mut = sc.nextInt();
                        
                        if(mut == 0){
                            System.out.println("MutationRate: (recomanat: 0.015)");
                            MutationRate = sc.nextDouble();
                        }
                        else if(mut == 1){
                            System.out.println("MutationRate: (recomanat: 0.015)");
                            MutationRate = sc.nextDouble();
                            
                            System.out.println("MutationSwapProbability: (recomanat: 0.9)");
                            MutationSwapProbability = sc.nextDouble();
                        }
                    }
                    try{
                        ArrayList<String> sol = Ctrl.tsp(nom, 1, StopCondition, Ngeneracions, NTours,
                            isg, Elitism, TS, TournamentSize, 
                            cross, mut, MutationRate, MutationSwapProbability,
                            id, 0, 0, 0);
                        System.out.println("");
                        for(int i = 0; i < sol.size(); ++i){
                            System.out.print("  " + sol.get(i));
                        }
                        System.out.println();
                    }
                    catch(ExceptionExistence e){
                        System.out.println(e.getMessage());
                    }
               
                }
            }
            System.out.println();
        }
    }
        
    
    public static void escriureCity(City ciutat){
        ArrayList<Punt> Pts = ciutat.getPunts();
        /*System.out.println("Printo els punts:");
        for(int i = 0; i < Pts.size(); ++i){
            System.out.println(Pts.get(i).getNom() + "    ");
        }
        System.out.println();*/
        
        ArrayList<ArrayList<Integer>> adj = ciutat.getAdjacency();
        System.out.println("Printo les adjacencies:");
        for(int i = 0; i < adj.size(); ++i){
            for(int ii = 0; ii < adj.get(i).size(); ++ii){
                System.out.print(adj.get(i).get(ii) + "    ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
