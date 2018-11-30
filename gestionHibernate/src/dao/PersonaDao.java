/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controlador.NewHibernateUtil;
import entidades.Persona;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author lautalb
 */
public class PersonaDao {

    public void guardar(Persona p) {
        try {
            SessionFactory sf = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sf.openSession();
            Transaction tx = session.beginTransaction();
            session.save(p);
            tx.commit();
            session.close();
            System.out.println("Guardado correctamente");
        } catch (Exception e) {
            System.out.println("Error en guardar: " + e.toString());
        }

    }

    public List listar() {
        List<Persona> lista = new ArrayList<>();
        try {
            SessionFactory sf = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sf.openSession();
            Transaction tx = session.beginTransaction();
            lista = session.createCriteria(Persona.class).list();
            tx.commit();
            session.close();
            System.out.println("Listado correctamente");

        } catch (Exception e) {
            System.out.println("Error en listar: " + e.toString());
        }

        return lista;

    }

    public void eliminar(Persona p) {
        try {
            SessionFactory sf = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sf.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(p);
            tx.commit();
            session.close();
            System.out.println("Eliminado correctamente");

        } catch (Exception e) {
            System.out.println("Error en eliminar: " + e.toString());
        }
    }

    public void actualizar(Persona p) {
        try {
            SessionFactory sf = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sf.openSession();
            Transaction tx = session.beginTransaction();
            session.update(p);
            tx.commit();
            session.close();
            System.out.println("Actualizado Correctamente");
        } catch (Exception e) {
            System.out.println("Error en actualizar: " + e.toString());
        }

    }

    public List<Persona> buscar(String opcion, String dato) {
        List<Persona> lista = new ArrayList<>();
        Query query;
        try {
            SessionFactory sf = NewHibernateUtil.getSessionFactory();
            Session session;
            session = sf.openSession();
            Transaction tx = session.beginTransaction();

            switch (opcion) {
                case "id":
                    query = session.createQuery("FROM Persona p WHERE p.id = :id");
                    query.setParameter("id", Integer.parseInt(dato));
                    lista = query.list();
                    break;
                case "nombre":
                    query = session.createQuery("FROM Persona p WHERE p.nombre = :nombre");
                    query.setParameter("nombre", dato);
                    lista = query.list();
                    break;
                case "apellido":
                    query = session.createQuery("FROM Persona p WHERE p.apellido = :apellido");
                    query.setParameter("apellido", dato);
                    lista = query.list();
                    break;  
            }
        } catch (Exception e) {
            System.out.println("Error en la busqueda: " + e.toString());
        }

        return lista;
    }
}
