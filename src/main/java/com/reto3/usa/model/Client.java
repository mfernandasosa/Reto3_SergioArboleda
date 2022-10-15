
package com.reto3.usa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table (name="client")
public class Client {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Integer idClient; 
   private String email;
   private String password;
   private String name;
   private Integer age;
   
   
   @OneToMany(cascade={CascadeType.PERSIST}, mappedBy="client")
   @JsonIgnoreProperties("client")
   public List<Message> messages;   
   
   @OneToMany(cascade={CascadeType.PERSIST}, mappedBy="client")
   @JsonIgnoreProperties("client")
   public List<Reservation> reservations;

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> Messages) {
        this.messages = Messages;
    }
   
}
