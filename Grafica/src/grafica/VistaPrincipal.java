/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grafica;

/**
 *
 * @author Carlos
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.Dialog;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.*;
import java.awt.Canvas;
import java.awt.image.*;
import java.awt.Graphics.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.JFileChooser;
import javax.swing.GroupLayout;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import javax.imageio.ImageIO;


public class VistaPrincipal {
    
    private JFrame vista = new JFrame("Vista Principal");
    private JTextArea text = new JTextArea();
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private Canvas can = new Canvas();
    
    
    
    public VistaPrincipal() {
        crearVentana();
    }
    private void crearVentana() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setLayout(new BorderLayout());
        panel1 = new JPanel();
        panel2 = new JPanel();
        vista.setSize(800,700);
        vista.setResizable(false);
        Menu m = new Menu();
        vista.setJMenuBar(m);
        vista.setVisible(true);
        
    }
   
    
    public class Vigila implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String aux = e.getActionCommand();
            text.setText(aux);
            if (aux.equals("Exit"))
                System.exit(0);
            else if (aux.equals("Choose image")) {
                panel1.removeAll();
                vista.remove(panel2);
                vista.remove(panel3);
                JFileChooser select = new JFileChooser();
                select.setDialogTitle("Selecciona una imagen");
                FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG","jpg");
                select.setFileFilter(filter);
                int aux2 = select.showOpenDialog(null);
                if (aux2 == JFileChooser.APPROVE_OPTION) {
                    try {
                        BufferedImage bmp;
                        JLabel label = new JLabel();
                        panel1.setSize(10,10);
                        label.setSize(10,10);
                        File image = select.getSelectedFile();
                        bmp = ImageIO.read(image);
                        label.setIcon(new ImageIcon(bmp));
                        panel1.add(label);
                        vista.add(panel1);
                        vista.getContentPane();
                        vista.repaint();
                        vista.setVisible(true);
                    }
                    catch(Exception i) {}
                        
                }
                
            }
            else if (aux.equals("SA options")) {
                optionssa();
            }
            else if (aux.equals("GA options")) {
                optionsga();
            }
        }
    }   
    
    public void optionssa() {
        vista.remove(panel1);
        vista.remove(panel3);
        JLabel l1 = new JLabel("Simulated Annealing's options: ");
        JLabel l2 = new JLabel ("Initial temperature: ");
        JTextField t1 = new JTextField();
        t1.setMinimumSize(new Dimension(300,25));
        t1.setPreferredSize(t1.getMinimumSize());
        t1.setMaximumSize(t1.getMinimumSize());
        JLabel l3 = new JLabel ("Cooling factor: ");
        JTextField t2 = new JTextField();
        t2.setMinimumSize(new Dimension(300,25));
        t2.setPreferredSize(t2.getMinimumSize());
        t2.setMaximumSize(t2.getMinimumSize());
        JLabel l4 = new JLabel ("Stop Condition: ");
        JTextField t3 = new JTextField();
        t3.setMinimumSize(new Dimension(300,25));
        t3.setPreferredSize(t3.getMinimumSize());
        t3.setMaximumSize(t3.getMinimumSize());
        GroupLayout layout = new GroupLayout(panel2);
        panel2.setLayout(layout);
       layout.setHorizontalGroup(layout
				.createSequentialGroup()
				.addGap(10, 10, 10)
				.addGroup(
						layout.createParallelGroup()
								.addComponent(l1)
								.addComponent(l2)
                                                                .addComponent(t1)
                                                                .addComponent(l3)
                                                                .addComponent(t2)
                                                                .addComponent(l4)
                                                                .addComponent(t3))		
                                                                .addGap(10, 10, 10));
        layout.setVerticalGroup(layout
				.createSequentialGroup()
				.addGap(10, 10, 10)
				.addComponent(l1)
				.addGap(10, 10, 10)
				.addComponent(l2)
				.addGap(10, 10, 10)
				.addComponent(t1)
				.addGap(10, 10, 10)   
                                .addComponent(l3)
				.addGap(10, 10, 10)
                                .addComponent(t2)
				.addGap(10, 10, 10)
                                .addComponent(l4)
				.addGap(10, 10, 10)
                                .addComponent(t3)
				.addGap(10, 10, 10)); 
                
        vista.add(panel2);
        vista.repaint();
        vista.setVisible(true);
    }
    
    public void optionsga() {
        vista.remove(panel1);
        vista.remove(panel2);
        JLabel l1 = new JLabel("Genetic algorithm's options");
        JLabel l2 = new JLabel("Stop Condtion: ");
        JTextArea t1 = new JTextArea();
        JLabel l3 = new JLabel("Number of generations: ");
        JTextArea t2  = new JTextArea();
        JLabel l4 = new JLabel("Number of tours");
        JTextArea t3 = new JTextArea();
        JLabel l5 = new JLabel("Elitism");
        JTextArea t4 = new JTextArea();
        JLabel l6 = new JLabel("Roulette Wheel");
        JTextArea t5 = new JTextArea();
        JLabel l7 = new JLabel("Tournament size");
        JTextArea t6 = new JTextArea();
        JLabel l8 = new JLabel("Edge Crossover");
        JTextArea t7 = new JTextArea(); 
        JLabel l9 = new JLabel("Mutation Rate");
        JTextArea t8 = new JTextArea();
        GroupLayout layout = new GroupLayout(panel3);
        panel3.setLayout(layout);
        layout.setHorizontalGroup(layout
				.createSequentialGroup()
				.addGap(10, 10, 10)
				.addGroup(
						layout.createParallelGroup()
								.addComponent(l1)
								.addComponent(l2)
                                                                .addComponent(t1)
                                                                .addComponent(l3)
                                                                .addComponent(t2)
                                                                .addComponent(l4)
                                                                .addComponent(t3)
                                                                .addComponent(l5)
                                                                .addComponent(t4)
                                                                .addComponent(l6)
                                                                .addComponent(t5)
                                                                .addComponent(l7)
                                                                .addComponent(t6)
                                                                .addComponent(l8)
                                                                .addComponent(t7)
                                                                .addComponent(l9)
                                                                .addComponent(t8))
                                                                .addGap(10, 10, 10));
        layout.setVerticalGroup(layout
				.createSequentialGroup()
				.addGap(10, 10, 10)
				.addComponent(l1)
				.addGap(10, 10, 10)
				.addComponent(l2)
				.addGap(10, 10, 10)
				.addComponent(t1)
				.addGap(10, 10, 10)   
                                .addComponent(l3)
				.addGap(10, 10, 10)
                                .addComponent(t2)
				.addGap(10, 10, 10)
                                .addComponent(l4)
				.addGap(10, 10, 10)
                                .addComponent(t3)
                                .addGap(10, 10, 10)
				.addComponent(l5)
				.addGap(10, 10, 10)
				.addComponent(t4)
				.addGap(10, 10, 10)
				.addComponent(l6)
				.addGap(10, 10, 10)  
                                .addComponent(t5)
                                .addGap(10, 10, 10)
				.addComponent(l7)
				.addGap(10, 10, 10)
				.addComponent(t6)
				.addGap(10, 10, 10)
				.addComponent(l8)
				.addGap(10, 10, 10)  
                                .addComponent(t7)
				.addGap(10, 10, 10)
				.addComponent(l9)
				.addGap(10, 10, 10)
				.addComponent(t8)
				.addGap(10, 10, 10)); 
        vista.add(panel3);
        vista.repaint();
        vista.setVisible(true);
        
        
        
    }
    
   /*class ChooseImage extends FileFilter {
    @Override   
    public  boolean accept(File f) {
        String extension=null;
        if (f.isDirectory()) 
          return true;
        String name = f.getName();
        int pos = name.lastIndexOf(".");
        if (pos >= 0 && name != null) 
            extension = name.substring(pos);
        if (extension != null) 
           if (extension.equals(".jpg"))
                return true;
        return false;        
    }
    @Override
    public String getDescription() {
        return "*.jpg";
    }
         
  }  */
    
class Menu extends JMenuBar {
        JMenu File;
        JMenu Algorithm;
        JMenu Help;
        Menu() {
            File = new JMenu("File");
            Algorithm = new JMenu("Algorithm");
            Help = new JMenu("Help");
            JMenuItem exit = new JMenuItem("Exit");
            JMenuItem image = new JMenuItem("Choose image");
            JMenuItem ga = new JMenuItem("GA options");
            JMenuItem sa = new JMenuItem("SA options");
            exit.addActionListener(new Vigila());
            image.addActionListener(new Vigila());
            ga.addActionListener(new Vigila());
            sa.addActionListener(new Vigila());
            File.add(image);
            File.add(exit);
            Algorithm.add(ga);
            Algorithm.add(sa);
            add(File);
            add(Algorithm);
            add(Help);
        }
    }

}