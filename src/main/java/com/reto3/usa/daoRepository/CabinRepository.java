
package com.reto3.usa.daoRepository;

import com.reto3.usa.daoRepository.CrudRepository.CabinCrudRepository;
import com.reto3.usa.model.Cabin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CabinRepository {
    @Autowired
    private CabinCrudRepository cabinCrudRepository;
    public List<Cabin>getAll(){
        return (List<Cabin>)cabinCrudRepository.findAll();            
    }
    public Optional<Cabin> getCabin(int id){
        return cabinCrudRepository.findById(id);
    }
    public Cabin save(Cabin cabin){
        return cabinCrudRepository.save(cabin);
    }
    public void delete(Cabin cabin){
        cabinCrudRepository.delete(cabin);
    }    
}
