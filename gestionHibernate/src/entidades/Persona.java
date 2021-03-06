package entidades;
// Generated 28-nov-2018 21:19:16 by Hibernate Tools 4.3.1


import dao.PersonaDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Persona generated by hbm2java
 */
public class Persona  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private String apellido;
     private Date fechaNacimiento;

    public Persona() {
    }

    public Persona(String nombre, String apellido, Date fechaNacimiento) {
       this.nombre = nombre;
       this.apellido = apellido;
       this.fechaNacimiento = fechaNacimiento;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento + '}';
    }


    public static void guardar(Persona p){
        PersonaDao persona = new PersonaDao();
        persona.guardar(p);
    }
    
    public static List<Persona> listar(){
        List<Persona> lista = new ArrayList<>();
        PersonaDao persona = new PersonaDao();
        lista = persona.listar();
        return lista;
    }
    
    public static void eliminar(Persona p){
        PersonaDao persona = new PersonaDao();
        persona.eliminar(p);
    }
    
    public static void actualizar(Persona p){
        PersonaDao persona = new PersonaDao();
        persona.actualizar(p);
    }
    
    public static List<Persona> buscar(String opcion, String dato){
        List<Persona> lista = new ArrayList<>();
        PersonaDao persona = new PersonaDao();
        lista = persona.buscar(opcion, dato);
        return lista;
    }

}


