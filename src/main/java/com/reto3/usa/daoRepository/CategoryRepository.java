
package com.reto3.usa.daoRepository;

import com.reto3.usa.daoRepository.CrudRepository.CategoryCrudRepository;
import com.reto3.usa.model.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;    
    public List<Category>getAll(){
        return (List<Category>) categoryCrudRepository.findAll();               
    }
    public Optional<Category> getCategory(int id){
        return categoryCrudRepository.findById(id);
    }
    public Category save(Category category){
        return categoryCrudRepository.save(category);
    }
    public void delete(Category category){
        categoryCrudRepository.delete(category);
    }    
}
