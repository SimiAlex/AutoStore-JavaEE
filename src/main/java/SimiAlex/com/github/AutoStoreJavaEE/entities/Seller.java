package SimiAlex.com.github.AutoStoreJavaEE.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sellers")
public class Seller 
{
    // fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type; // reprezentanta, privat, ...

    // TODO resolve mapping, including cascade type
    //private Set<Car> cars;

    // constructor

    // methods
    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getType() 
    {
        return type;
    }

    public void setType(String type) 
    {
        this.type = type;
    }

    // public Set<Car> getCars() 
    // {
    //     return cars;
    // }

    // public void setCars(Set<Car> cars) 
    // {
    //     this.cars = cars;
    // }
}
