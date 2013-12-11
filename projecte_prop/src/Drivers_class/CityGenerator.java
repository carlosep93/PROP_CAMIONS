/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Drivers_class;
import Domini.Tour;
import Domini.InitialSolGenerator_TwoApp;
import Domini.Mst_Prim;
import java.util.Scanner;
import Domini.Punt;
import Domini.City;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author joanbarrosogarrido
 */
public class CityGenerator {
    
    public static void main (String [] args) {
        City C = new City("joan");
        System.out.println("Escull numero de punts");
        Scanner sc = new Scanner(System.in);
        int qp = sc.nextInt();
        int x = 0;
        int y = 0;
        String s;
        System.out.println("random 0, manual 1");
        if (sc.nextInt() == 0){
            for (int i = 0; i < qp; ++i) {
                ArrayList<Integer> ali = new ArrayList();
                s = Integer.toString(x);
                Punt P = new Punt(x,y,s);
                ++x;++y;
                for(int j = 0; j <i; ++j) {
                    ali.add((int)(Math.random()*8+1));
                }
                    C.addElement(P, ali);
            }
        }
        else {
            for (int i = 0; i < qp; ++i) {
                ArrayList<Integer> ali = new ArrayList();
                s = Integer.toString(x);
                Punt P = new Punt(x,y,s);
                ++x;++y;
                for(int j = 0; j <i; ++j) {
                    ali.add(sc.nextInt());
                }
                    C.addElement(P, ali);
            }
        }
        for(int i = 0; i < C.size(); ++i) System.out.println("el elemento "+ i+ " esta "+ C.isEnabled(i));
        System.out.println("quieres borrar algun elemento? 0 =  no, 1 = si");
        int bool = sc.nextInt();
        while (bool == 1){
            System.out.print("Id del punt a esborrar: ");
            int mod = sc.nextInt();
            System.out.println();
            C.erase(mod);
            
        for(int i = 0; i < C.size(); ++i) System.out.println("el elemento "+ i+ " esta "+ C.isEnabled(i));
            bool = sc.nextInt();
        }
        
        for(int i = 0; i < C.size(); ++i) System.out.println("el elemento "+ i+ " esta "+ C.isEnabled(i));
        Mst_Prim prim = new Mst_Prim(C);
        InitialSolGenerator_TwoApp twoapp = new InitialSolGenerator_TwoApp(prim);
        Tour T = twoapp.generateInitialSol();
        List<Punt> lp = T.getCjtElements();
        for(int i = 0; i < lp.size(); ++i) {
            System.out.println(lp.get(i).getID());
        }
        System.out.println(T.getCost(C));
        
    }
}
