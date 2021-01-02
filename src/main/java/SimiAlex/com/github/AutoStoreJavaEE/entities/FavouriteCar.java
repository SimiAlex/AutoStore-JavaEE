package SimiAlex.com.github.AutoStoreJavaEE.entities;

import java.util.HashSet;
import java.util.Set;

public class FavouriteCar 
{
    //fields
    private Set<Car> favoriteCars;

    //constructor
    public FavouriteCar()
    {
        if (favoriteCars == null)
        {
            favoriteCars = new HashSet<>();
        }
    }
    //methods
    public Set<Car> getFavoriteCars() {
        return favoriteCars;
    }

    public void setFavoriteCars(Set<Car> favoriteCars) {
        this.favoriteCars = favoriteCars;
    }
}
