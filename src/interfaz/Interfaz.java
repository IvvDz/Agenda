package interfaz;
import dominio.Contacto;
import dominio.Libreta;

public class Interfaz {
    private Libreta libreta;
    public Interfaz() {
        this.libreta = new Libreta();
    }
    public Libreta getLibreta() {
        return this.libreta;
    }
    public void procesarEntrada(String[] args) {
        if (args.length == 0) {
            System.out.println("No se ha proporcionado ningún argumento.");
            return;
        }
        switch (args[0]) {
            case "add":
                if (args.length != 3) {
                    System.out.println("Se necesitan dos argumentos para añadir un contacto. Uso: add <nombre> <teléfono>");
                } else {
                    String nombre = args[1];
                    String telefono = args[2];
                    Contacto contacto = new Contacto(nombre, telefono);
                    libreta.anadirContacto(contacto);
                    System.out.println("Contacto añadido con éxito.");
                }
                break;
            case "list":
                System.out.println(libreta.toString());
                break;
            case "help":
                System.out.println("Las operaciones posibles son las siguientes:");
                System.out.println("- Añadir contacto: 'java -jar libreta.jar add <nombre> <teléfono>'");
                System.out.println("  Por ejemplo, java -jar libreta.jar add Pepe 654321234");
                System.out.println("- Mostrar contactos: java -jar libreta.jar list");
                System.out.println("- Mostrar esta ayuda: java -jar libreta.jar help");
                break;
            default:
                System.out.println("Operación no reconocida. Para ver la ayuda, use 'java -jar libreta.jar help'.");
                break;
        }
    }
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        interfaz.procesarEntrada(args);
    }
}

