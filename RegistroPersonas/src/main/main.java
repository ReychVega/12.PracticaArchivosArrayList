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
            //instancias
            Register r=new Register();
            Persona p =r.insertPersona();
            manejoArchivos mA=new manejoArchivos();
            
            //manejo de datos para registro por medio de JOptionPane
            if (p!=null && mA.verificaExistencia(p.getId())==false) {
               mA.guardarPersona(p);
            }else if(p==null){
            JOptionPane.showMessageDialog(null, "Datos incompletos.", "Error de registro", 0);
            }else if(p!=null && mA.verificaExistencia(p.getId())==true){
             JOptionPane.showMessageDialog(null, "Usuario ingresado previamente.", "Error de registro", 0);
            }
            
            mA.actualizaLista();
            if (!mA.archivoCompleto().isEmpty()) {
                JOptionPane.showMessageDialog(null,  mA.archivoCompleto());
            }

        } catch (IOException | ClassNotFoundException ex) {
              JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }
    
}
