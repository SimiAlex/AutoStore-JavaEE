package SimiAlex.com.github.AutoStoreJavaEE.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sellers")
public class Seller 
{
    // fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;
    private String type; // reprezentanta, privat, ...
    
    @NotNull
    private String password;

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

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
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
