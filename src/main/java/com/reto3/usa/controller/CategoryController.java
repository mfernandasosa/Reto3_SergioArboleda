package com.reto3.usa.controller;

import com.reto3.usa.model.Category;
import com.reto3.usa.service.CategoryService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/all")
    public List<Category>getAll(){
        return categoryService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Category>getCategory(@PathVariable("id")int id){
        return categoryService.getCategory(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category){
        return categoryService.save(category);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category category){
        return categoryService.update(category);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return categoryService.deleteCategory(id);
    }
}