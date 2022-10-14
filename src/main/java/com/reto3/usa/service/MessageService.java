package com.reto3.usa.service;

import com.reto3.usa.daoRepository.MessageRepository;
import com.reto3.usa.model.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message>getAll(){
        return messageRepository.getAll();               
    }
    public Optional<Message> getMessage(int messageId){
        return messageRepository.getMessage(messageId);
    }
    public Message save(Message message){
        if(message.getIdMessage()==null){
            return messageRepository.save(message);
        } else {     
            Optional<Message>messageEncontrado=getMessage(message.getIdMessage());
            if(messageEncontrado.isEmpty()){
                return messageRepository.save(message);
            } else {
                return message;
            }
        }
    }
    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message>messageEncontrado=getMessage(message.getIdMessage());
            if(!messageEncontrado.isEmpty()){
               if(message.getMessageText()!=null){
                   messageEncontrado.get().setMessageText(message.getMessageText());
               }
               return messageRepository.save(messageEncontrado.get());               
            }            
        }
        return message;                    
    }

    public boolean deleteMessage(int id){
        Boolean resultado = getMessage(id).map(messagePorEliminar ->{
            messageRepository.delete(messagePorEliminar);
            return true;
    }).orElse(false);
    return resultado;
    }   
}