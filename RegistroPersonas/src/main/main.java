package main;

import Domain.Persona;
import Domain.Register;
import Domain.manejoArchivos;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo 5
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Register r=new Register();
            //Persona p =new Persona("15","15","15","15","15"); 
            manejoArchivos mA=new manejoArchivos();
            mA.guardarPersona(r.insertPersona());
           
            JOptionPane.showMessageDialog(null,  mA.archivoCompleto());

        } catch (IOException | ClassNotFoundException ex) {
              JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }
    
}
