package business;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import entities.Usuario;
import javax.persistence.Query;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Victor Martinez, Nicolas Aldana
 * @version 1.0
 */
public class UsuarioDao {

    private EntityManagerFactory entityManager;

    public UsuarioDao() {
        entityManager = Persistence.createEntityManagerFactory("ProyectoSeminarioOpticaPU");
    }

    public Usuario ValidateUser(String nameUser, String password) {
        Usuario user;
        EntityManager manager = entityManager.createEntityManager();
        String sql = "SELECT u FROM Usuario u WHERE u.name = :name AND u.pass = :pass";
        Query query = manager.createQuery(sql);
        
        query.setParameter("name", nameUser);
        query.setParameter("pass", password); 
        
        user = (Usuario) query.getSingleResult();
        return user;
    }
}
