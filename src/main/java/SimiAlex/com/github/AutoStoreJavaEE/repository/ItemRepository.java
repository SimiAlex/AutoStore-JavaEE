package SimiAlex.com.github.AutoStoreJavaEE.repository;

import java.util.Set;

public interface ItemRepository<T, K> 
{
    void addItem(T item);
    Set<T> findAll();
    T findById(K id);
    void updateItem(T item);
    void deleteItem(K id);
}
