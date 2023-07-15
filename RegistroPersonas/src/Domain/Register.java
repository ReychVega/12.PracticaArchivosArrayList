package Domain;

import javax.swing.JOptionPane;

/**
 *
 * @author Grupo 5
 */
public class Register {
    public Persona persona;
    
    public Register() {
       persona=null; 
    }
        
    public Persona insertPersona() {
      
       try{ 
        String id = JOptionPane.showInputDialog(null, "Ingrese el ID");
        String name = JOptionPane.showInputDialog(null, "Ingrese el nombre");
        String lastName = JOptionPane.showInputDialog(null, "Ingrese el apellido");
        String phone = JOptionPane.showInputDialog(null, "Ingrese el telefono");
        String civilState = JOptionPane.showInputDialog(null, "ingrese el estado civil");
        
           if (id!=null & name!=null & lastName!=null & phone!=null & civilState!=null
                   & !id.isEmpty() & !name.isEmpty() & !lastName.isEmpty() & !phone.isEmpty() & !civilState.isEmpty()) {
            persona=new Persona(id, name, lastName,phone,civilState);
           }
        }catch(Exception e){
            return null;
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
