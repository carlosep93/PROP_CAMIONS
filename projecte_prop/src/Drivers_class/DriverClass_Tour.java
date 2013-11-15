
package Drivers_class;

import projecte_prop.Tour;
import projecte_prop.Element;
import projecte_prop.Relations;
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
        while(lectura != 16){   
            System.out.println();
            System.out.println("Tria una opció:");
            System.out.println("1 - Crear un Tour");
            System.out.println("2 - Afegeix Element");
            System.out.println("3 - Afegeix Element en la pos");
            System.out.println("4 - Contain Element");
            System.out.println("5 - Get Element Pos");
            System.out.println("6 - Get Pos Element");
            System.out.println("7 - Remove Element");
            System.out.println("8 - Remove Element en la pos");
            System.out.println("9 - Reemplaçar Tour");
            System.out.println("10 - Reemplaçar Tour Pos");
            System.out.println("11 - Swap Elements");
            System.out.println("12 - Swap Element Pos");
            System.out.println("13 - Size");
            System.out.println("14 - getCost");
            System.out.println("15 - Sortir");
            System.out.println();

            lectura=sc.nextInt();

            if(lectura == 1){
                ruta = new Tour();
            }
            else if(lectura == 2){
                System.out.println("id Element:");
                int id = sc.nextInt();
                Element E = new Element(id);

                ruta.addElement(E);
                escriureTour(ruta, R);
            }
            else if(lectura == 3){
                System.out.println("id Element:");
                int id = sc.nextInt();

                System.out.println("pos:");
                int pos = sc.nextInt();
                Element E = new Element(id);

                ruta.addElement(E, pos);
                escriureTour(ruta, R);
            }
            else if(lectura == 4){
                System.out.println("id Element:");
                int id = sc.nextInt();
                Element E = new Element(id);

                if(ruta.containsElement(E)){
                    System.out.println("SI el contè");
                }
                else System.out.println("No el contè");
            }
            else if(lectura == 5){
                System.out.println("pos:");
                int pos = sc.nextInt();

                System.out.println("És l'element: " + ruta.getElementPos(pos).getID());
            }
            else if(lectura == 6){
                System.out.println("id Element:");
                int id = sc.nextInt();
                Element E = new Element(id);

                System.out.println("Pos de l'element: "+ ruta.getPosElement(E));
            }
            else if(lectura == 7){
                System.out.println("id Element:");
                int id = sc.nextInt();
                Element E = new Element(id);

                ruta.removeElement(E);
                escriureTour(ruta, R);
            }
            else if(lectura == 8){
                System.out.println("Pos:");
                int pos = sc.nextInt();

                ruta.removeElement(pos);
                escriureTour(ruta, R);
            }
            else if(lectura == 9){
                System.out.println("id Element1:");
                int id = sc.nextInt();
                Element E1 = new Element(id);

                System.out.println("id Element2:");
                id = sc.nextInt();
                Element E2 = new Element(id);

                ruta.replaceElement(E1, E2);
                escriureTour(ruta, R);
            }
            else if(lectura == 10){
                System.out.println("id Element1:");
                int id = sc.nextInt();
                Element E1 = new Element(id);

                System.out.println("pos:");
                int pos = sc.nextInt();

                ruta.replaceElement(E1, pos);
                escriureTour(ruta, R);
            }
            else if(lectura == 11){
                System.out.println("id Element1:");
                int id = sc.nextInt();
                Element E1 = new Element(id);

                System.out.println("id Element2:");
                id = sc.nextInt();
                Element E2 = new Element(id);

                ruta.swap(E1,E2);
                escriureTour(ruta, R);
            }
            else if(lectura == 12){
                System.out.println("pos1:");
                int pos1 = sc.nextInt();

                System.out.println("pos2:");
                int pos2 = sc.nextInt();

                ruta.swap(pos1, pos2);
                escriureTour(ruta, R);
            }
            else if(lectura == 13){
                System.out.println("Size: " + ruta.size());
            }
            else if(lectura == 14){
                System.out.println("Cost: " + ruta.getCost(R));
            }
            System.out.println();
        }
    }
    
    private static void escriureTour(Tour T, Relations R){
        for(int i = 0; i < T.size(); ++i){
            System.out.print(" " + T.getElementPos(i).getID());
        }
        System.out.println();
        System.out.println(T.getCost(R));
    }
}
