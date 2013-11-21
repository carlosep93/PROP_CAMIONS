package pkg3capas;

public class MainEjemplo {
	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				CtrlPresentacion mainWindow = new CtrlPresentacion();
				mainWindow.inicializarPresentacion();
			}
		});

	}
}