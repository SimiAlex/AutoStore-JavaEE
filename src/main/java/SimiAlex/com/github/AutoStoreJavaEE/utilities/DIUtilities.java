/* 
 * This class contains static methods for dependecy injection.
 * Objects should be saved at the application scope level.
*/

package SimiAlex.com.github.AutoStoreJavaEE.utilities;

import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;

public class DIUtilities
{
    // fields
    private static final String PERSISTENCE_UNIT = "my-persistence-unit";
    private static final String ENTITY_MANAGER_ATTRIBUTE = "entityManager";

    // get the entity manager (for a specific persistence unit - to be implemented later)
    public static EntityManager getEntityManager(ServletContext application)
    {
        // try to retrieve em instance from application scope attributes
        EntityManager em = (EntityManager) application.getAttribute(ENTITY_MANAGER_ATTRIBUTE);

        // check for null and create an object if true, then set as application attribute
        if(Objects.isNull(em))
        {
            // first instantiate an EntityMagerFactory, then an EntityManager
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            em = emf.createEntityManager();

            // set em as an application scope attribute
            application.setAttribute(ENTITY_MANAGER_ATTRIBUTE, em);
        }
        
        // return em
        return em;
    }
}
