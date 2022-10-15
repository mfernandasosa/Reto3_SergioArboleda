package com.reto3.usa.controller;

import com.reto3.usa.model.Cabin;
import com.reto3.usa.service.CabinService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Cabin")
@CrossOrigin(origins = "*", methods ={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class CabinController {
    @Autowired
    private CabinService cabinService;
    @GetMapping("/all")
    public List<Cabin>getAll(){
        return cabinService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Cabin>getAdmin(@PathVariable("id")int id){
        return cabinService.getCabin(id);
    }    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin save(@RequestBody Cabin cabin) {
        return cabinService.save(cabin);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin update(@RequestBody Cabin cabin) {
        return cabinService.update(cabin);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean delete(@PathVariable("id") int id){
        return cabinService.deleteCabin(id);
    }
}
