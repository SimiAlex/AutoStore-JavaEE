package SimiAlex.com.github.AutoStoreJavaEE.utilities;

import java.util.Objects;

import javax.persistence.EntityManager;
import javax.servlet.ServletContext;

import SimiAlex.com.github.AutoStoreJavaEE.entities.Car;
import SimiAlex.com.github.AutoStoreJavaEE.entities.Seller;
import SimiAlex.com.github.AutoStoreJavaEE.repository.CarRepositoryImpl;
import SimiAlex.com.github.AutoStoreJavaEE.repository.ItemRepository;
import SimiAlex.com.github.AutoStoreJavaEE.repository.SellerRepositoryImpl;

public class DIRepositories 
{
    // fields
    private static final String CAR_REPOSITORY_ATTRIBUTE = "carRepo";
    private static final String SELLER_REPOSITORY_ATTRIBUTE = "sellerRepo";
    
    // methods - get car repository
    public static ItemRepository<Car, Integer> getCarRepository(ServletContext application)
    {
        // try to retrieve ItemRepository<Car> instance from application scope attributes
        ItemRepository<Car, Integer> carRepo = (ItemRepository<Car, Integer>) application.getAttribute(CAR_REPOSITORY_ATTRIBUTE);

        // check for null and create an object if true, then set as application attribute
        if(Objects.isNull(carRepo))
        {
            // instantiate an ItemRepository<Car> (one of the implementations)
            EntityManager em = DIUtilities.getEntityManager(application);
            carRepo = new CarRepositoryImpl(em);

            // set carRepo as an application scope attribute
            application.setAttribute(CAR_REPOSITORY_ATTRIBUTE, carRepo);
        }

        // return car repository
        return carRepo;
    }

    // methods - get seller repository
    public static ItemRepository<Seller, Long> getSellerRepository(ServletContext application)
    {
        // try to retrieve ItemRepository<Seller> instance from application scope attributes
        ItemRepository<Seller, Long> sellerRepo = (ItemRepository<Seller, Long>) application.getAttribute(SELLER_REPOSITORY_ATTRIBUTE);

        // check for null and create an object if true, then set as application attribute
        if(Objects.isNull(sellerRepo))
        {
            // instantiate an ItemRepository<Seller> (one of the implementations)
            EntityManager em = DIUtilities.getEntityManager(application);
            sellerRepo = new SellerRepositoryImpl(em);

            // set sellerRepo as an application scope attribute
            application.setAttribute(SELLER_REPOSITORY_ATTRIBUTE, sellerRepo);
        }

        // return car repository
        return sellerRepo;
    }
}
