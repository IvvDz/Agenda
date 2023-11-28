package dominio;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.Serializable;

public class Libreta implements Serializable{
    private ArrayList<Contacto> listaDeContactos;
    public Libreta() {
        this.listaDeContactos = new ArrayList<>();
    }
    public void anadirContacto(Contacto contacto) {
        listaDeContactos.add(contacto);
    }
    public void borrarContacto(String nombre) {
        Iterator<Contacto> iterador = listaDeContactos.iterator();
        while (iterador.hasNext()) {
            Contacto contacto = iterador.next();
            if (contacto.getNombre().equals(nombre)) {
                iterador.remove();
                System.out.println("Contacto eliminado con éxito.");
                return;
            }
        }
        System.out.println("No se encontró ningún contacto con el nombre especificado.");
    }
    public void modificarContacto(String nombre, Contacto nuevoContacto) {
        for (int i = 0; i < listaDeContactos.size(); i++) {
            Contacto contacto = listaDeContactos.get(i);
            if (contacto.getNombre().equals(nombre)) {
                listaDeContactos.set(i, nuevoContacto);
                System.out.println("Contacto modificado con éxito.");
                return;
            }
        }
        System.out.println("No se encontró ningún contacto con el nombre especificado para modificar.");
    }
    public List<String> obtenerListaDeContactos() {
        List<String> listaDeContactos = new ArrayList<>();
        for (Contacto contacto : this.listaDeContactos) {
            listaDeContactos.add(contacto.toString());
        }
        return listaDeContactos;
    }
    public void generarCSV(String nombreArchivo) {
        try {
            FileWriter fileWriter = new FileWriter(nombreArchivo);
            fileWriter.append("Nombre,Numero de Telefono\n");
            for (Contacto contacto : listaDeContactos) {
                fileWriter.append(contacto.getNombre())
                        .append(",")
                        .append(contacto.getNumeroDeTelefono())
                        .append("\n");
            }
            fileWriter.flush();
            fileWriter.close();
            System.out.println("Hoja de cálculo generada con éxito en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
