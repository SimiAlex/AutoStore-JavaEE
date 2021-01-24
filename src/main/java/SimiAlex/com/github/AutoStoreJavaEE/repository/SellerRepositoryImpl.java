package SimiAlex.com.github.AutoStoreJavaEE.repository;

import java.util.Set;

import javax.persistence.EntityManager;

import SimiAlex.com.github.AutoStoreJavaEE.entities.Seller;

public class SellerRepositoryImpl implements ItemRepository<Seller> 
{
    // fields
    private EntityManager em;

    // constructor
    public SellerRepositoryImpl(EntityManager em)
    {
        this.em = em;
    }

    // methods
    @Override
    public void addItem(Seller item) 
    {
        // TODO Auto-generated method stub

    }

    @Override
    public Set<Seller> findAll() 
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Seller findById(int id) 
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateItem(Seller item) 
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteItem(int id) 
    {
        // TODO Auto-generated method stub

    }
    
}
