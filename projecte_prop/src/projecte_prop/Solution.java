package projecte_prop;

import java.util.List;

/** Ejemplo de una clase de Dominio. **/
public class Solution {
	
	/** Atributos **/
	
	private int id;
	private String name;
	private int cost;
	private int date;
	private int[] idElements;
	private List<Relation> relations;
	
	/** Constructora **/
	
	public Solution(int id, String name, int date, int nelements, int nrel) {
		/* Pre: Recives identification, name, date, number of elements and number of relations. */
		this.id = id;
		this.name = name;
		cost = 0;
		this.date = date;
		idElements = new int[nelements];
		/* Post: Creates an object of type Solution with all the variables recieved and some default values. */
	}
	
	/** Métodos públicos **/

	public int getId() {
		/* Pre: - */
		return id;
		/* Post: Returns the identifications of the solution. */
	}

	public String getName() {
		/* Pre: - */
		return name;
		/* Post: Returns the name of the solution. */
	}

	public int getDate() {
		/* Pre: - */
		return date;
		/* Post: Returns the modified date of the soluiton. */
	}

	public int getCost() {
		/* Pre: - */
		return cost;
		/* Post: Returns the cost of solution. */
	}

	public int getPositionById(int id) {
		/* Pre: 'id' must be and id from the elements on the solution. */
		for (int i = 0; i < idElements.length; ++i) {
			if (idElements[i] = id) return i;
		}
		/* Post: Returns the position on the solution form the element with id 'id'. */
	}

	public int getIdByPosition(int pos) {
		/* Pre: 'pos' must be between 1 and the number of elements on the solution. */
		return idElements[pos-1];
		/* Post: Returns the id from the element on the position 'pos'. */
	}

	public int getRelationByIds(int id1, int id2) {
		/* Pre: 'id1' and 'id2' must be ids from elemens on the solution and must be diferent form each other */
		
		/* Post: Returns the value of the relation between the elements with ids 'id1' and 'id2' */
	}

	public void updateName(String name) {
		/* Pre: - */
		this.name = name;
		/* Post: The solution changes its name by 'name' */
	}
	
	public void addElementPosition(int id, int pos) {
		/* Pre: 'id' must be an id of an element from the solution and 'pos' must be between 1 and the number of elements on the solution. */
		positions[pos-1] = id;
		/* Post: Sets the position of the element with id 'id' to 'pos' */
	}

	public void addRelation(Relation relation) {
		/* Pre: The relation must be between two diferent elements from the solution */
		relations.add(relation);
		cost += relation.getValue();
		/* Post: Adds the relation 'relations' to the relations of the solution */
	}
	
	/** Métodos redefinidos **/
	
}
