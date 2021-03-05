package mx.edu.uacm.primerproyectohibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import mx.edu.uacm.primerproyectohibernate.domain.Usuario;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	Código legado
//      SessionFactory sf = new Configuration().configure().buildSessionFactory();
    	
//    	Crear registro estandar del servicio a través de un builder
    	StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
    	
//    	Creamos el sesion factory
    	SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
    	
//    	Abrir la sesión
    	Session session = sf.openSession();
    	
//    	Crear la entidad
    	Usuario usuario1 = new Usuario();
    	usuario1.setId(1);
    	usuario1.setNombreUsuario("Objeto1");
    	usuario1.setMensajeUsuario("Este mensaje es para el objeto1");
    	
    	Usuario usuario2 = new Usuario();
    	usuario2.setId(2);
    	usuario2.setNombreUsuario("Objeto2");
    	usuario2.setMensajeUsuario("Mensaje enviado del objeto2");
    	
//    	Crear transacción
    	session.getTransaction().begin();
    	session.persist(usuario1);
    	session.persist(usuario2);
    	
//    	Commit de la transacción
    	session.getTransaction().commit();
    	
    	session.close();
    	sf.close();
    }
}
