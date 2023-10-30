package aplicacion;
import interfaz.Interfaz;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    private static final String NOMBRE_ARCHIVO = "contactos.txt";
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        interfaz.procesarEntrada(args);
        guardarContactos(interfaz.getLibreta().obtenerListaDeContactos());
    }
    private static void guardarContactos(List<String> listaDeContactos) {
        try {
            FileWriter fileWriter = new FileWriter(NOMBRE_ARCHIVO);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String contacto : listaDeContactos) {
                bufferedWriter.write(contacto);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static List<String> cargarContactos() {
        List<String> listaDeContactos = new ArrayList<>();
        try {
            File file = new File(NOMBRE_ARCHIVO);
            if (file.exists()) {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String linea;
                while ((linea = bufferedReader.readLine()) != null) {
                    listaDeContactos.add(linea);
                }
                bufferedReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaDeContactos;
    }
}
