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
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import javax.imageio.ImageIO;


public class VistaPrincipal {
    
    private JFrame vista = new JFrame("Vista Principal");
    private JTextArea text = new JTextArea();
    private JPanel container1 = new JPanel();
    private JPanel container2 = new JPanel();
    private Canvas can = new Canvas();
    
    
    
    public VistaPrincipal() {
        crearVentana();
    }
    private void crearVentana() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setLayout(new BorderLayout());
        container1 = new JPanel();
        container2 = new JPanel();
        vista.setSize(600,500);
        vista.setResizable(false);
        Menu m = new Menu();
        vista.setJMenuBar(m);
        vista.setVisible(true);
        
    }
    
    public void ActivatC1() {
        
    }
    
    public class Vigila implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String aux = e.getActionCommand();
            text.setText(aux);
            if (aux.equals("Exit"))
                System.exit(0);
            else if (aux.equals("Choose image")) {
                JFileChooser select = new JFileChooser();
                select.setDialogTitle("Selecciona una imagen");
                FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG","jpg");
                select.setFileFilter(filter);
                int aux2 = select.showOpenDialog(null);
                if (aux2 == JFileChooser.APPROVE_OPTION) {
                    try {
                        BufferedImage bmp;
                        JLabel label = new JLabel();
                        container1.setSize(10,10);
                        label.setSize(10,10);
                        File image = select.getSelectedFile();
                        bmp = ImageIO.read(image);
                        label.setIcon(new ImageIcon(bmp));
                        container1.add(label);
                        vista.add(container1);
                        vista.getContentPane();
                        vista.setVisible(true);
                    }
                    catch(Exception i) {}
                        
                }
                
            }   
        }
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
            exit.addActionListener(new Vigila());
            image.addActionListener(new Vigila());
            File.add(image);
            File.add(exit);
            add(File);
            add(Algorithm);
            add(Help);
        }
    }

}