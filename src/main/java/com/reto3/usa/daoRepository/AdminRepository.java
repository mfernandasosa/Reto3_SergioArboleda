
package com.reto3.usa.daoRepository;

import com.reto3.usa.daoRepository.CrudRepository.AdminCrudRepository;
import com.reto3.usa.model.Admin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository {
    @Autowired
    private AdminCrudRepository adminCrudRepository;
    public List<Admin>getAll(){
        return (List<Admin>)adminCrudRepository.findAll();               
    }
    public Optional<Admin> getAdmin(int id){
        return adminCrudRepository.findById(id);
    }
    public Admin save(Admin admin){
        return adminCrudRepository.save(admin);
    }
    public void delete(Admin admin){
        adminCrudRepository.delete(admin);
    }    
}
