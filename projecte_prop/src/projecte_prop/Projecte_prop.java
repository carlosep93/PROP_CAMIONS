/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte_prop;

/**
 *
 * @author joanbarrosogarrido
 */
public class Projecte_prop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Relation r = new Relation(1,2,45);
        Relation r2 = new Relation (3,4,23);
        Cjt_Relations cjtr = new Cjt_Relations();
        cjtr.add(r);
        cjtr.add(r2);
        System.out.println("Print hashset: "+cjtr.getClass());
    }
}
