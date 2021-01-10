package SimiAlex.com.github.AutoStoreJavaEE.repository;

import java.util.Set;

import SimiAlex.com.github.AutoStoreJavaEE.entities.Car;

public interface CarRepository 
{
    void addCar(Car car);
    Set<Car> findAll();
    Car findById(int id);
    void updateCar(int id);
    void deleteCar(int id);
}
