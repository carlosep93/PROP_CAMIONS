/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CapaPresentacio;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class VistaError {
    
    private JDialog eMessage;
    
    public VistaError(String s) {
        JOptionPane panel = new JOptionPane(s,JOptionPane.ERROR_MESSAGE);
        eMessage = panel.createDialog(new JFrame(),"Error"); 
        eMessage.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        eMessage.setSize(400,200);
        eMessage.setVisible(true);
    }
    
}
