/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Pc
 */
@Entity
@Table
public class Persona implements Serializable {
    @Id
    @Column
    private int idPersona;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private int edad;
    @Column
    private String correo;
    @Column
    private String direccion;
    
    public Persona(){
        
    }
    
    public Persona(int id, String nombre, String apellido, int edad, String correo, String dir){
        this.idPersona = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
        this.direccion = dir;
    }
    
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "ID = " + idPersona + ", Nombre = " + nombre + ", Apellido = " + apellido + ", Edad = " + edad + ", Correo = " + correo + ", Direccion = " + direccion;
    }
    
    
}
