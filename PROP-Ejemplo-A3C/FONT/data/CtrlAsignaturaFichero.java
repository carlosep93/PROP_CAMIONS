package data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import domain.Asignatura;

/**
 * Implementación de la classe gestionadora de datos para la clase "Asignatura".
 **/
public class CtrlAsignaturaFichero {

	/**
	 * Implementación del patrón de diseño "Singleton", con el objetivo de que
	 * haya una única instancia de esta clase en el sistema. En este caso, esta
	 * propiedad es deseada ya que esta classe no tiene estado (astributos no
	 * estáticos). Para lograrlo, declaramos la constructora como privada y
	 * añadimos una operación estática que retorne siempre la misma instancia.
	 * Para acceder a esta instancia lo haremos mediante la llamada
	 * CtrlAsignaturaFicher.getInstance();
	 **/
	
	private static CtrlAsignaturaFichero singletonObject;

	public static CtrlAsignaturaFichero getInstance() {
		if (singletonObject == null)
			singletonObject = new CtrlAsignaturaFichero() {
			};
		return singletonObject;
	}

	/** Constructora privada. **/
	
	private CtrlAsignaturaFichero() {
	}

	public List<Asignatura> getAll(String filename)
			throws FileNotFoundException {
		LinkedList<Asignatura> asignaturas = new LinkedList<Asignatura>();

		FileReader fr = new FileReader("../DATA/"+filename);
		Scanner scan = new Scanner(fr);

		while (scan.hasNextLine())
			asignaturas.add(new Asignatura(scan.nextLine()));

		return asignaturas;
	}
}
