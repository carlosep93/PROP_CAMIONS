
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

public class DriverClass_CtrlDomini {
    
        public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        
        int lectura = 0;
        while(lectura != 7){   
            System.out.println();
            System.out.println("Tria una opció:");
            System.out.println("1 - Inicia Domini");
            System.out.println("2 - Afegir Element");
            System.out.println("3 - Consultar Element");
            System.out.println("4 - Modificar Element");
            System.out.println("5 - Eliminar Element");
            System.out.println("6 - Generar Camí");
            lectura=sc.nextInt();

            if(lectura == 1){
                CtrlDomini.iniciarDomini();
            }
            else if(lectura == 2){
                int id = CtrlDomini.getnewID();
                
                System.out.println("Nom:");
                sc.nextLine();
                String nom = sc.nextLine();
                
                //System.out.println("X:");
                int x = 0;          //int x = sc.nextInt();
                //System.out.println("Y:");
                int y = 0;                    //int y = sc.nextInt();
               
                boolean enabled = true;
                
                Element E = new Element(id, nom, x, y, enabled);
                
                boolean[] b = CtrlDomini.getActius();
                List<Integer> ll = new ArrayList<Integer>();
                
                for(int i = 0; i < b.length; ++i){
                    if(b[i]){
                        System.out.println("Pes de l'element a : " + 
                            CtrlDomini.getCity().get_Tour().getElementPos(i).getNom());
                        ll.add(sc.nextInt());
                    }
                    else ll.add(-1);
                }
                CtrlDomini.addElement(E, ll);
                
                escriureCjtElem(CtrlDomini.getCjtElement());
                escriureRelations(CtrlDomini.getRelations());
            }
            else if(lectura == 3){
               /* System.out.println("Nom:");
                String nom = sc.nextLine();
                
                CtrlDomini.consultaElement(nom);*/
            }
            else if(lectura == 4){
                /*int id = CtrlDomini.getnewID();
                
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
                
                CtrlDomini.modificaElement(E, nom);*/
            }
            else if(lectura == 5){
                System.out.println("Nom:");
                sc.nextLine();
                String nom = sc.nextLine();
                
                CtrlDomini.eliminaElement(nom);
                
                escriureCjtElem(CtrlDomini.getCjtElement());
                escriureRelations(CtrlDomini.getRelations());
            }
            else if(lectura == 6){
                System.out.println("1, SistemAnnealing// 2, GeneticAlgorithm:");
                int alg = sc.nextInt();
                if(alg == 1){
                    System.out.println("Nom de la solucio:");
                    sc.nextLine();
                    String nom = sc.nextLine();
                    
                    
                    System.out.println("Temperatura inicial: ");
                    double tmp = sc.nextDouble();
                    
                    System.out.println("factor de pèrdua de temp: ");
                    double fact = sc.nextDouble();
                    
                    
                    System.out.println("parada: ");
                    int par = sc.nextInt();
                    
                    CtrlDomini.tspSA(nom, tmp, fact, par);                    
                }
                else{
                    //System.out.println("Nom de la solucio:");
                    //sc.nextLine();
                    String nom = "hola"; //sc.nextLine();
                    
                    //System.out.println("StopCondition:");
                    int StopCondition = 20; //sc.nextInt();
                    
                    //System.out.println("NGeneracions:");
                    int Ngeneracions = 1000; //sc.nextInt();
                    
                    //System.out.println("NTours:");
                    int NTours = 50;//sc.nextInt();
                    
                    //System.out.println("Elitism:");
                    boolean Elitism = true;// sc.nextBoolean();
                    
                    //System.out.println("RouletteWheel_TS:");
                    boolean RouletteWheel_TS = true;//= sc.nextBoolean();
                    
                    int TournamentSize = 0;
                    if(!RouletteWheel_TS){
                      //  System.out.println("TournamentSize:");
                        TournamentSize = 2;//sc.nextInt();
                    }
                    
                   // System.out.println("Edge_crossover:");
                    boolean Edge_crossover = false;//sc.nextBoolean();
                    
                   // System.out.println("Mutate2:");
                    boolean Mutate2 = true;//sc.nextBoolean();
                    
                    //System.out.println("MutationRate:");
                    double MutationRate = 0.015;//sc.nextDouble();
                    
                    double MutationSwapProbability = 0;
                    if(Mutate2){
                       // System.out.println("MutationSwapProbability:");
                        MutationSwapProbability = 0.9; //sc.nextDouble();
                    }
                    
                    CtrlDomini.tspGA(nom, StopCondition, Ngeneracions, 
                            NTours, Elitism, RouletteWheel_TS, TournamentSize, 
                            Edge_crossover, Mutate2, MutationRate, 
                            MutationSwapProbability);
                    
                }
                escriureSolucio();
            }
            
            
            System.out.println();
        }
    }
    
    public static void escriureCjtElem(Tour cjtElem){
        Tour t = CtrlDomini.getCity().get_Tour();
        for(int i = 0; i < t.size(); ++i){
            System.out.print(" " + t.getElementPos(i).getID());
        }
        System.out.println();
    }
    
    public static void escriureRelations(Relations R){
        Relations r = CtrlDomini.getCity().get_Relations();
        for(int i = 0; i < r.size(); ++i){
            System.out.println(r.toString(i));
        }
        System.out.println();
    }
    
    public static void escriureSolucio(){
        Solution sol = CtrlDomini.getSolution();
        System.out.println("Nom solució: " + sol.getNom());
        for(int i = 0; i < sol.getTour().size(); ++i){
            System.out.print(" " + sol.getTour().getElementPos(i).getID());
        }
        System.out.println();
    }
}
