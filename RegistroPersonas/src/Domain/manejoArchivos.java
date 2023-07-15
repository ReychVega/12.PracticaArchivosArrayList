package Domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grupo 5
 */
public class manejoArchivos {

    private ArrayList<Persona> personas;
    private File archivo;
    
    public manejoArchivos() {
        personas = new ArrayList<>();
        archivo = new File("persons.dat");
        
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }
    
    //métodos
    public void guardarPersona(Persona person) throws FileNotFoundException, IOException, ClassNotFoundException {
        
        // System.out.println(element.toString());
        if (archivo.exists()) {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream((archivo)));
            Object aux = input.readObject();
            this.personas=((ArrayList<Persona>) (List<Persona>) aux);
           // System.out.println(piloto.toString());
            input.close();
        }
        
        this.personas.add(person);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(("persons.dat")));
        output.writeUnshared(this.personas);
        output.close();
    }
    
    public boolean verificaExistencia(String dni){
    if (archivo.exists()) {
            try {
                ObjectInputStream input = new ObjectInputStream(new FileInputStream((archivo)));
                Object aux = input.readObject();
                this.personas=((ArrayList<Persona>) (List<Persona>) aux);
                // System.out.println(piloto.toString());
                input.close();
            } catch (IOException | ClassNotFoundException ex) {
                return false;
            }
        }
    
        if(!this.personas.isEmpty()){
            for (int i = 0; i < this.personas.size(); i++) {
                if (this.personas.get(i).getId().equalsIgnoreCase(dni)) {
                 return true;   
                }
            }
        }
    
        return false;
    }
    
    //actualiza lista en caso de datos nuevos
    public void actualizaLista(){
    if (archivo.exists()) {
            try {
                ObjectInputStream input = new ObjectInputStream(new FileInputStream((archivo)));
                Object aux = input.readObject();
                this.personas=((ArrayList<Persona>) (List<Persona>) aux);
                // System.out.println(piloto.toString());
                input.close();
            } catch (IOException | ClassNotFoundException ex) {
                
            }
        }
    
    }  

     //desplega lista
    public String archivoCompleto() throws IOException, FileNotFoundException, ClassNotFoundException{
       String s="";
        for (int i = 0; i < this.personas.size(); i++) {
            s+=this.personas.get(i).toString()+"\n";
        }
        return s;
    }
    
}