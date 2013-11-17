
package Drivers_class;

import projecte_prop.Tour;
import projecte_prop.Element;
import Stubs.Relations;
import java.util.Scanner;

/**
 *
 * @author josep
 */
public class DriverClass_Tour {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        Relations R = new Relations();
        Tour ruta = new Tour();
        int lectura = 0;
        while(lectura != 20){   
            System.out.println();
            System.out.println("Tria una opció:");
            System.out.println("1  - Crear un Tour");
            System.out.println("2  - Afegeix Element");
            System.out.println("3  - Afegeix Element en la pos");
            System.out.println("4  - Contain Element Id");
            System.out.println("5  - Contain Element Nom");
            System.out.println("6  - Get Element Pos");
            System.out.println("7  - Get Element Nom");
            System.out.println("8  - Get Pos Element");
            System.out.println("9  - Remove Element");
            System.out.println("10 - Remove Element en la pos");
            System.out.println("11 - Remove Element amb nom");
            System.out.println("12 - Inhabilita Element");
            System.out.println("13 - Reemplaçar Element");
            System.out.println("14 - Reemplaçar Element Pos");
            System.out.println("15 - Reemplaçar Element Nom");
            System.out.println("16 - Swap Elements Id");
            System.out.println("17 - Swap Element Pos");
            System.out.println("18 - Size");
            System.out.println("19 - getCost");
            System.out.println("20 - Sortir");
            System.out.println();

            lectura=sc.nextInt();

            if(lectura == 1){
                ruta = new Tour();
            }
            else if(lectura == 2){
                System.out.println("id Element:");
                int id = sc.nextInt();
                
                System.out.println("nom Element:");
                sc.nextLine();
                String nom = sc.nextLine();
                
                Element E = new Element(id, nom, 0, 0, true);

                ruta.addElement(E);
                escriureTour(ruta);
            }
            else if(lectura == 3){
                System.out.println("id Element:");
                int id = sc.nextInt();

                System.out.println("pos:");
                int pos = sc.nextInt();
                Element E = new Element(id);

                ruta.addElement(E, pos);
                escriureTour(ruta);
            }
            else if(lectura == 4){
                System.out.println("id Element:");
                int id = sc.nextInt();
 
                if(ruta.containsElement(id)){
                    System.out.println("SI el contè");
                }
                else System.out.println("No el contè");
            }
            else if(lectura == 5){
                System.out.println("nom Element:");
                sc.nextLine();
                String nom = sc.nextLine();
                if(ruta.containsElement(nom)){
                    System.out.println("SI el contè");
                }
                else System.out.println("No el contè");
            }
            else if(lectura == 6){
                System.out.println("pos:");
                int pos = sc.nextInt();

                System.out.println("És l'element: " + ruta.getElementPos(pos).getID());
            }
            else if(lectura == 7){
                System.out.println("nom Element:");
                sc.nextLine();
                String nom = sc.nextLine();

                System.out.println("És l'element: " + ruta.getElementNom(nom).getID());
            }
            else if(lectura == 8){
                System.out.println("id Element:");
                int id = sc.nextInt();

                System.out.println("Pos de l'element: "+ ruta.getPosElement(id));
            }
            else if(lectura == 9){
                System.out.println("id Element:");
                int id = sc.nextInt();

                ruta.removeElement(id);
                escriureTour(ruta);
            }
            else if(lectura == 10){
                System.out.println("Pos:");
                int pos = sc.nextInt();

                ruta.removeElementPos(pos);
                escriureTour(ruta);
            }
            else if(lectura == 11){
                System.out.println("Nom:");
                sc.nextLine();
                String nom = sc.nextLine();

                ruta.removeElement(nom);
                escriureTour(ruta);
            }
            else if(lectura == 12){
                System.out.println("Pos:");
                int pos = sc.nextInt();

                ruta.inhabilitaElement(pos);
                escriureTour(ruta);
            }
            else if(lectura == 13){
                System.out.println("id de l'Element nou:");
                int id = sc.nextInt();
                Element E = new Element(id);

                System.out.println("id de l'Element substituit:");
                int id2 = sc.nextInt();

                ruta.replaceElementId(E, id2);
                escriureTour(ruta);
            }
            else if(lectura == 14){
                System.out.println("id Element nou:");
                int id = sc.nextInt();
                Element E1 = new Element(id);

                System.out.println("pos:");
                int pos = sc.nextInt();

                ruta.replaceElementPos(E1, pos);
                escriureTour(ruta);
            }
            else if(lectura == 15){
                System.out.println("id Element nou:");
                int id = sc.nextInt();
                Element E1 = new Element(id);

                System.out.println("Nom:");
                sc.nextLine();
                String nom = sc.nextLine();

                ruta.replaceElement(E1, nom);
                escriureTour(ruta);
            }
            
            else if(lectura == 16){
                System.out.println("id Element1:");
                int id1 = sc.nextInt();

                System.out.println("id Element2:");
                int id2 = sc.nextInt();

                ruta.swapId(id1, id2);
                escriureTour(ruta);
            }
            else if(lectura == 17){
                System.out.println("pos1:");
                int pos1 = sc.nextInt();

                System.out.println("pos2:");
                int pos2 = sc.nextInt();

                ruta.swap(pos1, pos2);
                escriureTour(ruta);
            }
            else if(lectura == 18){
                System.out.println("Size: " + ruta.size());
            }
            else if(lectura == 19){
                System.out.println("Cost: " + ruta.getCost());
            }
            System.out.println();
        }
    }
    
    private static void escriureTour(Tour T){
        for(int i = 0; i < T.size(); ++i){
            System.out.print(" " + T.getElementPos(i).getID());
        }
        System.out.println();
        System.out.println(T.getCost());
    }
}
