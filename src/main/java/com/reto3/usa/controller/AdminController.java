
package com.reto3.usa.controller;

import com.reto3.usa.model.Admin;
import com.reto3.usa.service.AdminService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*")
public class AdminController {
    @Autowired
    private AdminService adminService;
    
    @GetMapping("/all")
    public List<Admin>getAll(){
        return adminService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Admin>getAdmin(@PathVariable("id")int id){
        return adminService.getAdmin(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin admin){
        return adminService.save(admin);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin update(@RequestBody Admin admin) {
        return adminService.update(admin);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return adminService.deleteAdmin(id);
    }
}
