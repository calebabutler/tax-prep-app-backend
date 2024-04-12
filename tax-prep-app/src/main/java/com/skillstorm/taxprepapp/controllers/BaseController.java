package com.skillstorm.taxprepapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.skillstorm.taxprepapp.services.BaseService;

/* All other controller classes in this project derive from this controller.
 * The type it accepts is a model, for example Product, ProductCategory,
 * ProductType, or Warehouse.
 *
 * The BaseController implements a generic CRUD interface. To create a new
 * controller for a given model, do something like this:
 * 
 * 
 * @RestController
 * @RequestMapping("/product_categories")
 * public class ProductCategoryController extends BaseController<ProductCategory> {
 * 
 *     @Autowired
 *     void setService(ProductCategoryService service) {
 *         this.service = service;
 *     }
 * 
 * }
 *
 * It is important to have a good RequestMapping as that determines what URL
 * you use to access this controller's API, as well as to autowire the
 * equivalent service to your controller.
 */

@CrossOrigin("http://127.0.0.1:5500/")
public class BaseController<T> {

    // Make sure to also implement setService, and make it Autowired!
    protected BaseService<T> service;

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T object) {
        Optional<T> optional = service.create(object);
        if (optional.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optional.get());
    }

    @GetMapping
    public ResponseEntity<List<T>> find(T example) {
        List<T> objects = service.find(example);
        if (objects.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(objects);
    }

    @PutMapping
    public ResponseEntity<T> update(@RequestParam int id, @RequestBody T object) {
        Optional<T> optional = service.update(id, object);
        if (optional.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optional.get());
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
