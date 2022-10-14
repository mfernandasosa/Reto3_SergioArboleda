
package com.reto3.usa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table (name="message")
public class Message implements Serializable {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Integer idMessage; 
   private String messageText;
   
   @ManyToOne
   @JoinColumn(name="cabinId")
   @JsonIgnoreProperties({"messages","reservations"})
   private Cabin cabin;
   
   @ManyToOne
   @JoinColumn(name="clientId")
   @JsonIgnoreProperties({"messages","reservations"})
   private Client client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Cabin getCabin() {
        return cabin;
    }

    public void setCabin(Cabin cabin) {
        this.cabin = cabin;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

      
}
