/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte_prop;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos2
 */


public class City {
    
    List<List<Integer>> llr;
    String nom;
    List<Punt> lp;
    
    public City(String nom) {
         llr = new ArrayList <List<Integer>>();
         lp = new ArrayList<Punt>();
         this.nom = nom;
    }
    
   public void addElement(Punt P, Relation[] v) {
       List<Integer> aux = new ArrayList<Integer>();
       for (int i = 0; i < v.length; ++i) {
           aux.add(v[i].getValue());
           llr.get(i).add(v[i].getValue());
       }
       llr.add(P.getID(), aux);
       lp.add(P.getID(),P);
   }
   
   
   //pre: llr !buida
   public int getCost(int id1, int id2) {
        return llr.get(id1).get(id2);

        
    }
    
    public int getCost(Element e1,Element e2) {
        int id1 = e1.getID();
        int id2 = e2.getID();
        return llr.get(id1).get(id2);
    }
    
    public boolean isEnabled(int id) {
        return lp.get(id).isEnabled();
    }
    
    
    
    
    
    /** @brief  Esborra un element de la Relations
        \pre    La Relation ha de contenir elements    
        \post   L'element indicat per el parametre id es marca com esborrat
    */
    public void erase(int id){
        lp.get(id).modifyEnabled(false);
    }
    
        /** @brief  Habilita un element de la Relations
        \pre    La Relation ha de contenir l'element   
        \post   L'element indicat per el parametre id es marca com habilitat
    */
    public void enable(int id) {
        lp.get(id).modifyEnabled(true);
    }
    /** @brief  Agefeix un element a la Relation
        \pre    La Relation ha de estar inicialitzada    
        \post   La Relation conté les relacions anteriors més la nova
    */    
    /*public void addElement(int id) {
        Scanner in = new Scanner(System.in);
        int x;
        List<Integer> aux = new ArrayList<Integer>();
        for (int i=0; i<id;++i) {
            if (a.get(i).get(a.get(i).size()-1) != 0) 
                aux.add(-1);
            else {
                x = in.nextInt();
                aux.add(x);
            }   
        }
        aux.add(0);
        a.add(aux);
    }
    */
     /** @brief  Afegeix un element de la Relations
        \pre    La Relation ha de contenir elements    
        \post   L'element indicat per el parametre id es marca com esborrat
    */
    /*public void addElement(List<Integer> l) {
        l.add(0);
        a.add(l);
    }
    */
    /** @brief  Transforma la relations en una matriu
        \pre    La relations ha d'estar inicialitzada  
        \post   Retorna una matriu de les relacions del elements actius
    */
    /*public int [][] toMatrix() {
        int n = 0;
        boolean [] b = new boolean [a.size()];
        for (int j=0;j < a.size(); ++j) {   //calcula vector de bools
            if (a.get(j).get(a.get(j).size()-1) == -1) {
                b[j] = true;
                ++n;
            }
        }    
        int [][] aux = new int [a.size()][a.size()];
       
        for (int i=0;i<a.size();++i){    //matriu gran
            for (int j=0;j <= i;++j) {
                aux[i][j] = aux[j][i] = a.get(i).get(j);
            }
        }
        int [][] res = new int [a.size()-n][a.size()-n];
        int a1 = 0;
        int a2 = 0; 
        for(int i=0; i<aux.length ; ++i){
            if(!b[i]){
                
            for(int j=0; j<aux.length; ++j){
              if(!b[j]){
                res[a1][a2] = aux[i][j];
                ++a2;
              }
            }
            ++a1;
            a2=0;
         }
      }    
        return res;
    }*/
    
    /** @brief  Nombre de punts de la Relations
        \pre    La Relation ha estat inicialitzada  
        \post   Retorna el tamany de la Relations
    */
    public int size() {
        return le.size();
    }
    
    /** @brief  Elements actius
        \pre    La Relation ha d'estar inicialitzada  
        \post   Retorna una llista amb el elements actius ordenats per ID
    */
    /*public List<Integer> Actius() {
        List<Integer> l = new ArrayList<Integer>();
        for (int i=0;i<a.size();++i) {
            if (a.get(i).get(a.get(i).size()-1) == 0)
                l.add(i);
        }
        return l;
    }
    */
    
    /** @brief  LLegeix la Relation de tecla
        \pre    La relations ha d'estar inicialitzada  
        \post   La Relation conté els elements introduits.
    */
    /*public void readRelations(int n) {
        for (int i=0;i<n;++i) {
            addElement(i);
        }
    }
    * */

    /** @brief  Transforma les relacions d'un element.
        \pre    La relations ha d'estar inicialitzada  
        \post   Retorna les relacions d'un element a un Strings
    */    

    
    public List<List<Integer>> getAdjacency(){
        return llr;
    }

    
    public String getNom() {
        return nom;
    }
    
    public List<Punt> getPunts() {
        return lp;
    }

    /*public String toString(int id) {
        return lli.get(id).toString();        
    } 
    */
}
