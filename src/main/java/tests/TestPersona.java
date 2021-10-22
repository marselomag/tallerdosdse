/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import Clases.Persona;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author Pc
 */
public class TestPersona {
    private static EntityManager manager;
    private static EntityManagerFactory emf;
  
    public static void main(String[] args){
        emf = Persistence.createEntityManagerFactory("Persistence");
        manager = emf.createEntityManager();
        Scanner teclado = new Scanner(System.in);
        int op = 0, ide=0, campo=0, idp, edadp;
        String value, nombre, apellido, direccion, correo;
        System.out.println("\n\n");
        System.out.println("******* TALLER PRACTICO 2 *******\n");
        while(op != 5){
        op = 0;
        System.out.println("Seleccione una opcion");
        System.out.println("1. Ver todos los registros");
        System.out.println("2. Agregar un registro");
        System.out.println("3. Editar un registro");
        System.out.println("4. Eliminar un registro");
        System.out.println("5. Salir");
        op = teclado.nextInt();
        switch(op){
            case 1:
                imprimirTodo();
                System.out.println("\n");
            break;
            case 2:
                System.out.println("Ingrese el ID");
                idp = teclado.nextInt();
                System.out.println("Ingrese el Nombre");
                nombre = teclado.next();
                System.out.println("Ingrese el Apellido");
                apellido = teclado.next();
                System.out.println("Ingrese la Edad");
                edadp = teclado.nextInt();
                System.out.println("Ingrese el Correo");
                correo = teclado.next();
                System.out.println("Ingrese el Direccion");
                direccion = teclado.next();
                guardarPersona(idp, nombre, apellido, edadp, correo, direccion);
                break;
            case 3:
                System.out.println("Ingrese el ID del registro que editara: ");
                ide = teclado.nextInt();
                System.out.println("Ingrese el campo que editara: ");
                System.out.println("1. Id\n2. Nombre\n3. Apellido\n4. Edad\n5. correo \n6. Direccion: ");
                campo = teclado.nextInt();
                System.out.println("Ingrese el nuevo valor: ");
                value = teclado.next();
                editarPersona(ide, campo, value);
            break;
            case 4:
                System.out.println("Ingrese el ID del registro que eliminara: ");
                ide = teclado.nextInt();
                eliminarPersona(ide);
            break;
            default:
            System.out.println("Adios.....");
        }
        teclado.nextLine();
        }
        
    }
    
    private static void imprimirTodo(){
        List<Persona> personas = (List<Persona>) manager.createQuery("FROM Persona").getResultList();
        for(Persona pers : personas){
            System.out.println(pers.toString());
        }
    }
    
    private static void guardarPersona(int id, String nombre, String apellido, int edad, String correo, String direccion){
        Persona p = new Persona(id, nombre, apellido, edad, correo, direccion);
        manager.getTransaction().begin();
        manager.persist(p);
        manager.getTransaction().commit();
        System.out.println("\nRegistro agregado");
        System.out.println(p.toString());
    }
    
    private static void editarPersona(int id, int campo, String value){
        manager.getTransaction().begin();
        Persona p = manager.find(Persona.class, id);
        switch(campo){
            case 1:
                
               break;
            case 2:
                p.setNombre(value);
                break;
            case 3:
                p.setApellido(value);
                break;
            case 5:
                p.setCorreo(value);
                break;
            case 6:
                p.setDireccion(value);
                break;
        }
        System.out.println("\nRegistro actualizado");
        System.out.println(p.toString());
        manager.getTransaction().commit();
        System.out.println("\n");
    }
    
    private static void eliminarPersona(int ide){
        manager.getTransaction().begin();
        Persona p = manager.find(Persona.class, ide);
        manager.remove(p);
        manager.getTransaction().commit();
    }
}
