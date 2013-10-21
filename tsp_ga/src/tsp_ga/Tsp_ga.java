
package tsp_ga;


//importa llibreries per poder llegir de teclat
import java.util.Scanner;

public class Tsp_ga {
    
    //nombre de generacions sense variar per donar una solució per bona
    static int stopCondition = 20;
    //max de generacions que es crearan
    static int nGeneracions = 1000;

    
    public static void main(String[] args) {
        //inicialització de la variable per llegir de la entrada estàndart
        Scanner in = new Scanner(System.in);
        
        
        //System.out.println("Escriu el nombre de punts: ");    //lectura del teclat
        //int npunts = in.nextInt();
        
        int npunts = 1000;         //pel joc de proves ja fet                                         
        
        Population pop = new Population(npunts);
        
        pop.ompla_pesos_jp3();
        pop.ompla_population_random();
        
        /*System.out.println("Pesos:");
        pop.escriu_pesos();
        System.out.println("Population inicial:");
        pop.escriu_population();*/
        
        int Fittest = pop.getFittest();
        int Fitness = pop.getFitness(Fittest); 
        System.out.println("Generació 0     Fitness: " + Fitness);

        int nCicles = 0;
        int bFittest = Fittest;
        int bFitness= Fitness;
        
        //iteracions per evolucionar la població
        for(int i = 1; i <= nGeneracions; ++i){
            //evoluciona la població en una generació
            pop.envolvePopulation();
            
            //obtè el millor element de la població i el seu cost total
            Fittest = pop.getFittest();
            Fitness = pop.getFitness(Fittest);
            System.out.println("Generació " + i + "     Fitness: " + Fitness);
            
            //si fa tantes generacions que no ha cambiat el millor element de
            //la població com defineix "stopCondition" no crea més generacions
            if(bFitness > Fitness){
                bFittest = Fittest;
                bFitness = Fitness;
                nCicles = 0;
            }
            else{
                ++nCicles;
                if(nCicles == stopCondition) break;
            }
        }
        
        //escriu la ruta més òptima
        System.out.println("La ruta final és: ");
        pop.escriu_ruta(Fittest);
        
    }
}