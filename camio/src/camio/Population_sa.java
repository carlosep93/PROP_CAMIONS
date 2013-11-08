 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package camio;

//import java.util.Scanner;


public class Population_sa {
    
    int npunts;
    int pesos[][];
    int population[];
    
    public Population_sa(int npunts) {
        this.npunts=npunts;
        pesos = new int[npunts][npunts];
        population = new int[npunts];
    }
    
    public Population_sa(Population_sa p) {
        this.npunts = p.npunts;
        this.pesos = new int[npunts][npunts];
        this.population = new int [npunts];
        for (int i=0;i<p.npunts;++i) {
            this.population[i] = p.population[i];
        }
        for (int j=0;j<this.npunts;++j) {
            for (int k=0; k<this.npunts;++k) {
                this.pesos[j][k]=p.pesos[j][k];
            }
        }
    }    
    
    public void ompla_population_random(){
        
        //omplim la population
        for(int ii=0;ii<npunts;++ii){
            population [ii]=ii;
        }
        int k,aux,aux2;
        k = (int)(Math.random()*10)+1;
        for (int j=0;j<npunts;++j) {
            if (k < 5) {
               aux2 = population[j]; 
               aux = (int)(Math.random()*npunts);
               population [j] = population [aux];
               population [aux] = aux2;

            }
           k = (int)(Math.random()*10)+1; 
        }     
    }
           
    public void swap(int i,int j) {
        int aux = population[i];
        population[i] = population[j];
        population[j] = aux;
    }
    
    public void escriu_population(){
        //escriu la population
        for(int ii=0;ii<npunts;++ii){
                System.out.print(" "+population[ii]);
            }
            System.out.println();
    }
    
     public void escriu_ruta(int ruta){
        for(int i = 0; i < npunts; ++i){
            System.out.println(" " + population[i]);
        }
    }
     
    public void twoSwap(Population_sa p,int i, int k) {
        for (int j=0;j<i;++i) {
            this->population[j] = p.population[j];
        }
        int aux = i;
        for  (int j=k; j>i;--j) {
            this->polation[j] =p.population[aux];
            ++aux;
        }
        for (int j=k;j<p.tamany();++j) {
            this->population[j] = p.population[j];
        }
    }
     
  /*  public void ompla_pesos(){
        System.out.println("Escriu els valors dels costos d'anar del punt: ");
        for(int i=0;i<npunts;++i){
            for(int ii=0;ii<npunts;++ii){
                System.out.print(i + ", " + ii + ": ");
                pesos[i][ii]=in.nextInt();
                System.out.println();
            }
        }
    }
*/    
    public int tamany() {
        return npunts;
    }
 
   public int getCost_ruta(){
        int cost=0;
        int p, p2;
        for(int i = 0; i < npunts-1; ++i){
            p = population [i];
            p2 = population [i+1];
            cost+=pesos[p][p2];
        }
        return cost;
    }     
      //joc de proves
    public void ompla_pesos_jp(){
        pesos[0][0] = 0;
        pesos[0][1] = 5;
        pesos[0][2] = 10;
        pesos[0][3] = 11;
        pesos[0][4] = 5;
        pesos[0][5] = 12;
        
        pesos[1][0] = 5;
        pesos[1][1] = 0;
        pesos[1][2] = 11;
        pesos[1][3] = 5;
        pesos[1][4] = 12;
        pesos[1][5] = 13;
        
        pesos[2][0] = 10;
        pesos[2][1] = 11;
        pesos[2][2] = 0;
        pesos[2][3] = 12;
        pesos[2][4] = 5;
        pesos[2][5] = 5;
        
        pesos[3][0] = 11;
        pesos[3][1] = 5;
        pesos[3][2] = 12;
        pesos[3][3] = 0;
        pesos[3][4] = 12;
        pesos[3][5] = 5;
        
        pesos[4][0] = 5;
        pesos[4][1] = 12;
        pesos[4][2] = 5;
        pesos[4][3] = 11;
        pesos[4][4] = 0;
        pesos[4][5] = 12;
        
        pesos[5][0] = 12;
        pesos[5][1] = 13;
        pesos[5][2] = 5;
        pesos[5][3] = 5;
        pesos[5][4] = 12;
        pesos[5][5] = 0;
        
    }
    
     public void ompla_pesos_jp2(){
        for (int i = 0; i < 100; ++i){
            for(int ii = 0; ii <= i; ++ii){
                if(i == ii) pesos[i][ii] = 0;
                else{
                    if(i%2 == 0){ //parell
                        pesos[i][ii] = pesos[ii][i] = 5;
                    }
                    else{
                        if(ii%2 == 0){
                            pesos[i][ii] = pesos[ii][i] = 10;
                        }
                        else pesos[i][ii] = pesos[ii][i] = 20;
                    }
                }
            }
        } 
    }
     public void ompla_pesos_jp3(){
        for (int i = 0; i < 1000; ++i){
            for(int ii = 0; ii <= i; ++ii){
                if(i == ii) pesos[i][ii] = 0;
                else{
                    if(i%2 == 0){ //parell
                        pesos[i][ii] = pesos[ii][i] = 5;
                    }
                    else{
                        if(ii%2 == 0){
                            pesos[i][ii] = pesos[ii][i] = 10;
                        }
                        else pesos[i][ii] = pesos[ii][i] = 20;
                    }
                }
            }
        } 
    }
}
