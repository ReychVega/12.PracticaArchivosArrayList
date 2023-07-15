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

    ArrayList<Persona> persona;

    public manejoArchivos() {
        persona = new ArrayList<>();
    }

    //métodos
    public void guardarPersona(Persona person) throws FileNotFoundException, IOException, ClassNotFoundException {
        
        File archivo = new File("persons.dat");

        // System.out.println(element.toString());
        if (archivo.exists()) {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream((archivo)));
            Object aux = input.readObject();
            this.persona=((ArrayList<Persona>) (List<Persona>) aux);
           // System.out.println(piloto.toString());
            input.close();
        }
        
        this.persona.add(person);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(("persons.dat")));
        output.writeUnshared(this.persona);
        output.close();
    }

     //desplega lista
    public String archivoCompleto() throws IOException, FileNotFoundException, ClassNotFoundException{
        
        return this.persona.toString();
    }
    
}
