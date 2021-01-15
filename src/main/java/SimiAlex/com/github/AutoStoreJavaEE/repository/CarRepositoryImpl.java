package SimiAlex.com.github.AutoStoreJavaEE.repository;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import SimiAlex.com.github.AutoStoreJavaEE.entities.Car;

public class CarRepositoryImpl implements CarRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    private EntityManager em = emf.createEntityManager();

    @Override
    public void addCar(Car car) {
        em.getTransaction().begin();
        em.persist(car);
        em.getTransaction().commit();

    }

    @Override
    public Set<Car> findAll() 
    {    
        List<Car> cars = em.createQuery("from Car").getResultList();
        Set<Car> carsSet = Set.copyOf(cars);
        return carsSet;
    }

    @Override
    public Car findById(int id) {
        Car car  = em.find(Car.class, id);
        return car;
    }

    @Override
    public void updateCar(int id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteCar(int id) {
        // TODO Auto-generated method stub

    }
    
}
