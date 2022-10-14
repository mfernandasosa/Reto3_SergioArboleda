package com.reto3.usa.service;

import com.reto3.usa.daoRepository.CabinRepository;
import com.reto3.usa.model.Cabin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CabinService {
    @Autowired
    private CabinRepository cabinRepository;
    
    public List<Cabin>getAll(){
        return cabinRepository.getAll();               
    }
    public Optional<Cabin> getCabin(int cabinId){
        return cabinRepository.getCabin(cabinId);
    }
    public Cabin save(Cabin cabin){
        if(cabin.getId()==null){
            return cabinRepository.save(cabin);
        } else {     
            Optional<Cabin>cabinEncontrado=cabinRepository.getCabin(cabin.getId());
            if(cabinEncontrado.isEmpty()){
                return cabinRepository.save(cabin);
            } else {
                return cabin;
            }
        }
    }
    public Cabin update(Cabin cabin){
        if(cabin.getId()!=null){
            Optional<Cabin>cabinEncontrado=cabinRepository.getCabin(cabin.getId());
            if(!cabinEncontrado.isEmpty()){
               if(cabin.getName()!=null){
                   cabinEncontrado.get().setName(cabin.getName());
               }
               if(cabin.getBrand()!=null){
                   cabinEncontrado.get().setBrand(cabin.getBrand());         
               }  
               if(cabin.getDescription()!=null){
                   cabinEncontrado.get().setDescription(cabin.getDescription());
               }
               if(cabin.getCategory()!=null){
                   cabinEncontrado.get().setCategory(cabin.getCategory());
               }
               return cabinRepository.save(cabinEncontrado.get());
            }
        }
        return cabin;
    }
    public boolean deleteCabin(int id){
        Boolean resultado = getCabin(id).map((var cabinPorEliminar) ->{
            cabinRepository.delete(cabinPorEliminar);
            return true;
    }).orElse(false);
    return resultado;
    }
}
