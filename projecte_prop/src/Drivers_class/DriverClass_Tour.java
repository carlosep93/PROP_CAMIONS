
package Drivers_class;

import projecte_prop.Tour;
import projecte_prop.Element;
import java.util.Scanner;

/**
 *
 * @author josep
 */
public class DriverClass_Tour {
    
    public static void main(){
        Scanner sc = new Scanner(System.in);
        
        Tour ruta = new Tour();
        int lectura = 0;
        while(lectura != 18){   
          System.out.println();
          System.out.println("Tria una opció:");
          System.out.println("1 - Crear un Tour complet");
          System.out.println("2 - Crear un Tour parcial");
          System.out.println("3 - Afegeix Element");
          System.out.println("4 - Afegeix Element en la pos");
          System.out.println("5 - Contain Element");
          System.out.println("6 - Get Pos Element");
          System.out.println("7 - Remove Element");
          System.out.println("8 - Remove Element en la pos");
          System.out.println("9 - Get Element Pos");
          System.out.println("10 - Swap Elements");
          System.out.println("11 - Swap Element Pos");
          System.out.println("12 - Size");
          System.out.println("13 - getCost");
          System.out.println("14 - getID");
          System.out.println("15 - getData");
          System.out.println("16 - getNom");
          System.out.println("17 - Escriure Tour");
          System.out.println("18 - Sortir");
          System.out.println();

          lectura=sc.nextInt();
          
          if(lectura == 1){
              ruta = new Tour();
          }
          else if(lectura == 2){
              System.out.println("Id:");
              int id = sc.nextInt();
              
              System.out.println("Nom:");
              String nom = sc.next();
              
              System.out.println("data:");
              int data = sc.nextInt();
              ruta = new Tour(id, nom, data);
          }
          else if(lectura == 3){
              System.out.println("id Element:");
              int id = sc.nextInt();
              Element E = new Element(id, true);
              
              System.out.println("L'ha afegit: " + ruta.addElement(E));
          }
          else if(lectura == 4){
              System.out.println("id Element:");
              int id = sc.nextInt();
              
              System.out.println("pos:");
              int pos = sc.nextInt();
              
              Element E = new Element(id, true);
              System.out.println("L'ha afegit: " + ruta.addElementPos(E, pos));
          }
          else if(lectura == 5){
              System.out.println("id Element:");
              int id = sc.nextInt();
              Element E = new Element(id, true);
              
              if(ruta.containsElement(E)){
                  System.out.println("SI el contè");
              }
              else System.out.println("No el contè");
          }
          else if(lectura == 6){
              System.out.println("id Element:");
              int id = sc.nextInt();
              Element E = new Element(id, true);
              
              System.out.println("pos de l'element: "+ ruta.getPosElement(E));
          }
          else if(lectura == 7){
              System.out.println("id Element:");
              int id = sc.nextInt();
              Element E = new Element(id, true);
              
              System.out.println("L'ha borrat: " + ruta.removeElement(E));
          }
          else if(lectura == 8){
              System.out.println("pos:");
              int pos = sc.nextInt();
              
              System.out.println("L'ha borrat: " + ruta.removeElementPos(pos));
          }
          else if(lectura == 9){
              System.out.println("pos:");
              int pos = sc.nextInt();
              
              System.out.println("És l'element: " + ruta.getElementPos(pos).getID());
              
          }
          else if(lectura == 10){
              System.out.println("id Element1:");
              int id = sc.nextInt();
              Element E1 = new Element(id, true);
              
              System.out.println("id Element2:");
              id = sc.nextInt();
              Element E2 = new Element(id, true);
              
              System.out.println("ha fet swapt: " + ruta.swapElem(E1,E2));
          }
          else if(lectura == 11){
              System.out.println("pos1:");
              int pos1 = sc.nextInt();
              
              System.out.println("pos2:");
              int pos2 = sc.nextInt();
              
              System.out.println("ha fet swapt: " + ruta.swapPos(pos1, pos2));
          }
          else if(lectura == 12){
              System.out.println("Size: " + ruta.size());
          }
          else if(lectura == 13){
              System.out.println("Cost: " + ruta.getCost());
          }
          else if(lectura == 14){
              System.out.println("ID: " + ruta.getID());
          }
          else if(lectura == 15){
              System.out.println("Data: " + ruta.getData());
          }
          else if(lectura == 16){
              System.out.println("Nom: " + ruta.getNom());
          }
          else if(lectura == 17){
              for(int i = 0; i < ruta.size(); ++i){
                  System.out.print(" " + ruta.getElementPos(i).getID());
              }
              System.out.println();
          }
          
        }  
    }
}
