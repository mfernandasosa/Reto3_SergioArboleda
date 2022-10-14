package com.reto3.usa.service;

import com.reto3.usa.daoRepository.CategoryRepository;
import com.reto3.usa.model.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
     public List<Category>getAll(){
        return categoryRepository.getAll();               
    }
    public Optional<Category> getCategory(int categoryId){
        return categoryRepository.getCategory(categoryId);
    }
    public Category save(Category category){
        if(category.getId()==null){
            return categoryRepository.save(category);
        } else {     
            Optional<Category>categoryEncontrado=categoryRepository.getCategory(category.getId());
            if(categoryEncontrado.isEmpty()){
                return categoryRepository.save(category);
            } else {
                return category;
            }
        }
    }
    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category>categoryEncontrado=categoryRepository.getCategory(category.getId());
            if(!categoryEncontrado.isEmpty()){
               if(category.getName()!=null){
                   categoryEncontrado.get().setName(category.getName());
               }
               if(category.getDescription()!=null){
                   categoryEncontrado.get().setDescription(category.getDescription());
               }
               return categoryRepository.save(categoryEncontrado.get());
            }
        }
        return category;
    }
    public boolean deleteCategory(int categoryId){
        Boolean resultado = getCategory(categoryId).map(categoryPorEliminar ->{
            categoryRepository.delete(categoryPorEliminar);
            return true;
    }).orElse(false);
    return resultado;
    }
}