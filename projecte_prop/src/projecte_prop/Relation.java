
package projecte_prop;

public class Relation {
    
    /*Atributes*/
    private int id1;
    private int id2;
    private int value;

    /*Constructor*/    
    public Relation(int id1, int id2, int value) {
        this.id1 = id1;
        this.id2 = id2;
        this.value = value;
    }
    
    /*Getters*/ 
    public int getID1() {
        return id1;
    }
    
    public int getID2() {
        return id2;
    }

    public int getValue() {
        return value;
    }
    
    /*Setter*/
    public void updateValue(int newvalue) {
        this.value = newvalue;
    }
    
    public void print() {
        System.out.println("Similaritat(" + id1 + ",\t" + id2 + ")\t= " + value);
    }
}

