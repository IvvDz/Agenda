package dominio;

import java.io.Serializable;

public class Contacto implements Serializable {
    private String nombre;
    private String numeroDeTelefono;

    public Contacto(String nombre, String numeroDeTelefono) {
        this.nombre = nombre;
        this.numeroDeTelefono = numeroDeTelefono;
    }
    public Contacto() {
        this.nombre = "";
        this.numeroDeTelefono = "";
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNumeroDeTelefono() {
        return numeroDeTelefono;
    }
    public void setNumeroDeTelefono(String numeroDeTelefono) {
        this.numeroDeTelefono = numeroDeTelefono;
    }
    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", numeroDeTelefono='" + numeroDeTelefono + '\'' +
                '}';
    }
}

