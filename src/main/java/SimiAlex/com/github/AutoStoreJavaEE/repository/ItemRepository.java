package SimiAlex.com.github.AutoStoreJavaEE.repository;

import java.util.Set;

public interface ItemRepository<T> 
{
    void addItem(T item);
    Set<T> findAll();
    T findById(int id);
    void updateItem(T item);
    void deleteItem(int id);
}
