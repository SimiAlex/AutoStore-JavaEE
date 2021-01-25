package SimiAlex.com.github.AutoStoreJavaEE.repository;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import SimiAlex.com.github.AutoStoreJavaEE.entities.Car;

public class CarRepositoryImpl implements ItemRepository<Car, Integer> 
{
    // fields
    private EntityManager em;

    // constructors
    public CarRepositoryImpl(EntityManager em)
    {
        this.em = em;
    }

    // methods
    @Override
    public void addItem(Car car) 
    {
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
    public Car findById(Integer id) 
    {
        Car car  = em.find(Car.class, id);
        return car;
    }

    @Override
    public void updateItem(Car car) 
    {
        em.getTransaction().begin();
        em.merge(car);
        em.getTransaction().commit();
    }

    @Override
    public void deleteItem(Integer id) 
    {
        // retrieve car by id
        Car car = findById(id);

        // delete care from database
        em.getTransaction().begin();
        em.remove(car);
        em.getTransaction().commit();
    }
    
}