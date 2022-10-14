
package com.reto3.usa.daoRepository.CrudRepository;

import com.reto3.usa.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer>{
    
}
