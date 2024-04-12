package com.skillstorm.taxprepapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

/* All other service classes in this project derive from this class. The type
 * it accepts is a model, for example Product, ProductCategory, ProductType,
 * or Warehouse.
 * 
 * The BaseService implements the logic necessary for creating a generic CRUD
 * interface with a BaseController-derived controller. To create a new service
 * for a given model, do something like this:
 * 
 * 
 * @Service
 * public class ProductService extends BaseService<Product> {
 * 
 *     @Override
 *     public boolean isValidForCreate(Product product) {
 *         // Add logic for determining whether the product is acceptable for
 *         // a post request.
 *     }
 * 
 *     @Override
 *     public boolean isValidForUpdate(Integer id, Product product) {
 *         // Add logic for determining whether an id and a product is
 *         // acceptable for a put request.
 *     }
 * 
 *     @Autowired
 *     void setRepository(ProductRepository repository) {
 *         this.repository = repository;
 *     }
 * 
 * }
 * 
 * How I have designed my post requests is that they will only accept a new
 * entry if all columns are set _except_ for the id. This ensures that there
 * are no null entries, which could make the database cumbersome with which
 * to work.
 * 
 * How I have designed my put requests is that they will only accept a new
 * entry if all columns are set except for the id, and if the id is not null.
 * This ensures that put requests perform an update, rather than add a new row
 * into the database table.
 */

public abstract class BaseService<T> {

    protected JpaRepository<T, Integer> repository;

    public abstract boolean isValidForCreate(T object);
    public abstract boolean isValidForUpdate(Integer id, T object);
    // Make sure to also implement setRepository, and make it Autowired!

    public Optional<T> create(T object) {
        if (object != null && isValidForCreate(object)) {
            return Optional.of(repository.save(object));
        }
        return Optional.empty();
    }

    public List<T> find(T object) {
        if (object != null) {
            return repository.findAll(Example.of(object));
        }
        return new ArrayList<>();
    }

    public Optional<T> update(int id, T object) {
        if (object != null && isValidForUpdate(id, object)) {
            return Optional.of(repository.save(object));
        }
        return Optional.empty();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

}
