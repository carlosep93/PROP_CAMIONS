
package Domini;

import java.util.ArrayList;


public class City {
    
    private ArrayList<ArrayList<Integer>> lli = new ArrayList <ArrayList<Integer>>();
    private String nom;
    private ArrayList<Punt> lp = new ArrayList<Punt>();
    
    public City(String nom) {
         lli = new ArrayList <ArrayList<Integer>>();
         lp = new ArrayList<Punt>();
         this.nom = nom;
    }
   
   public void addElement(Punt P, ArrayList<Integer> pesos_resta){
       for(int i = 0; i < lp.size(); ++i){
           if(isEnabled(i)) lli.get(i).add(pesos_resta.get(i));
           else{
               lli.get(i).add(-1);
               pesos_resta.add(i, -1);
           }
       }
       
       lp.add(P);
   
       pesos_resta.add(P.getID(), 0);
       lli.add(P.getID(), pesos_resta);
   }

   
   
   public void rehabilitaElement(int id, ArrayList<Integer> pesos_resta){
       enable(id);
       for (int i = 0; i < size();++i){
           if (lli.get(id).get(i) == -1 && lp.get(i).isEnabled()) {
               lli.get(id).set(i,pesos_resta.get(0));
               lli.get(i).set(id,pesos_resta.get(0));
               pesos_resta.remove(0);
           }
       }
       
   }

   public void setDades (ArrayList <ArrayList<Integer>> llista, ArrayList<Punt> punts){
       lli = new ArrayList <ArrayList<Integer>>();
       lli = llista;
       lp = new ArrayList<Punt>();
       lp = punts;
   }

   public void repPesos(int idPunt, Integer[] pesosNew){
       if(pesosNew.length == lli.get(idPunt).size()){
           for(int i = 0; i < pesosNew.length; ++i){
               lli.get(idPunt).remove(i);
               lli.get(idPunt).add(i, pesosNew[i]);
           }
       }
   }
   
   
   //pre: llr !buida
   public int getCost(int id1, int id2) {
        return lli.get(id1).get(id2);

        
    }
    
    public int getCost(Punt p1,Punt p2) {
        int id1 = p1.getID();
        int id2 = p2.getID();
        return lli.get(id1).get(id2);
    }
    
    public boolean isEnabled(int id) {
        return lp.get(id).isEnabled();
    }
    
    
    public ArrayList<String> getEnabled(){
        ArrayList<String> Actius = new ArrayList<String>();
        for(int i = 0; i < size(); ++i){
            if(isEnabled(i)) Actius.add(lp.get(i).getNom());
        }
        return Actius;
    }
    
    public ArrayList<Integer> getEnabledInt(){
        ArrayList<Integer> Actius = new ArrayList<Integer>();
        for(int i = 0; i < size(); ++i){
            if(isEnabled(i)) Actius.add(lp.get(i).getID());
        }
        return Actius;
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
    
    /** @brief  Nombre de punts de la Relations
        \pre    La Relation ha estat inicialitzada  
        \post   Retorna el tamany de la Relations
    */
    public int size() {
        return lp.size();
    }

    public ArrayList<ArrayList<Integer>> getAdjacency(){
        return lli;
    }

    
    public String getNom() {
        return nom;
    }
    
    public ArrayList<Punt> getPunts() {
        return lp;
    }
}
