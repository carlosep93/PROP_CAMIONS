
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
        
        int lectura = 0;
        while(lectura != 8){   
            System.out.println();
            System.out.println("Tria una opció:");
            System.out.println("1 - Inicia Domini");
            System.out.println("2 - Afegir Element");
            System.out.println("3 - Consultar Element");
            System.out.println("4 - Modificar Element");
            System.out.println("5 - Eliminar Element");
            System.out.println("6 - Carregar adjacencies de Memoria");
            System.out.println("7 - Generar Camí");
            System.out.println("8 - Sortir");
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
                  System.out.println("Ubuntu(1) o windows(2) ?");
                  if( sc.nextInt()==2 ) pathload = "src\\Fitxers\\";
                  System.out.println("Quin fitxer vols?");
                  String aux = sc.next();
                  pathload = pathload+aux;
                  Relations rela = new Relations (Gestor_Dades.carregar_adjacencies(pathload)); 
                  CtrlDomini.modificarRelationsCity(rela);
             } 
            
            
            else if(lectura == 7){
                boolean predef = true;
                System.out.println("1, SistemAnnealing// 2, GeneticAlgorithm:");
                 int alg = sc.nextInt();
                 System.out.println("Vols usar els paràmetres predefinits?");
                 if(sc.next() == "no") predef = false;
               
               
                if(alg == 1){
                    String nom;
                    double tmp;
                    double fact;
                     int par;
                    if(predef){
                       nom = "sense_nom"; 
                       tmp = 1000;
                       fact = 0.03;
                       par = 25;
                    }
                    else{
                    System.out.println("Nom de la solucio:");
                    sc.nextLine();
                    nom = sc.nextLine();
                    
                    
                    System.out.println("Temperatura inicial (recomanat:1000) : ");
                    tmp = sc.nextDouble();
                    
                    System.out.println("factor de pèrdua de temp: (recomanat: 0.03) :");
                    fact = sc.nextDouble();
                    
                    
                    System.out.println("parada: (recomanat: 25) ");
                    par = sc.nextInt();
                    }
                    CtrlDomini.tspSA(nom, tmp, fact, par);                    
                }
                else{
                    
                    String nom = "Sense_nom";
                    int StopCondition = 20;
                    int Ngeneracions = 1000;
                    int NTours = 50;
                    boolean Elitism = true;
                    boolean RouletteWheel_TS = true;
                    int TournamentSize = 0;
                    boolean Edge_crossover = false;
                    boolean Mutate2 = true;
                    double MutationRate = 0.15;
                    double MutationSwapProbability = 0.9;
                    
                     if(predef){
                    nom = "Sense_nom";
                    StopCondition = 20;
                    Ngeneracions = 1000;
                    NTours = 50;
                   Elitism = true;
                    RouletteWheel_TS = true;
                    TournamentSize = 0;
                    Edge_crossover = false;
                    Mutate2 = true;
                    MutationRate = 0.15;
                    MutationSwapProbability = 0.9;
                    } 
                    else{
                    System.out.println("Nom de la solucio:");
                    sc.nextLine();
                    nom = sc.nextLine();
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
                    
                    System.out.println("Edge_crossover: (recomanat: false)");
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
