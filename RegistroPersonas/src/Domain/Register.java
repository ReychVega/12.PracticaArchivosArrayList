package Domain;

import javax.swing.JOptionPane;

/**
 *
 * @author Grupo 5
 */
public class Register {
    public Persona persona;
    public Register() {
       persona=new Persona(); 
    }
        
    public Persona insertPersona() {
      
       try{ 
        String id = JOptionPane.showInputDialog(null, "ingrese el ID");
        String name = JOptionPane.showInputDialog(null, "ingrese el nombre");
        String lastName = JOptionPane.showInputDialog(null, "ingrese el apellido");
        String phone = JOptionPane.showInputDialog(null, "ingrese el telefono");
        String civilState = JOptionPane.showInputDialog(null, "ingrese el estado civil");
        persona=new Persona(id, name, lastName,phone,civilState);
        }catch( Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return persona;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
      
     public void mostrar() {
        if (this.persona != null) {
            JOptionPane.showMessageDialog(null, this.persona.toString());
        }
    } 
    
}
