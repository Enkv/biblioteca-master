package cl.colegioelbelloto.biblioteca.Usuarios;

import jakarta.persistence.*;
import lombok.NonNull;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ⚡ genera el ID en la BD
    private Long idUsuario;
    @NonNull
    private String rut;
    @NonNull
    private String nombre;
    @NonNull
    private String apellido;
    @NonNull
    private String email;
    @NonNull
    private String telefono;
    @NonNull

    public Usuario (Long idUsuario, String rut, String nombre, String apellido, String email, String telefono) {
        this.idUsuario = idUsuario;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    public Usuario () {

    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void mostrarDatos(){

    }

}