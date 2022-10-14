
package com.reto3.usa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table (name="reservation")
public class Reservation implements Serializable {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Integer idReservation; 
   private Date startDate;
   private Date devolutionDate;
   private String status = "created";
   
   @ManyToOne
   @JoinColumn(name="cabinId")
   @JsonIgnoreProperties("reservations")
   private Cabin cabin;

   @ManyToOne
   @JoinColumn(name="clientId")
   @JsonIgnoreProperties({"reservations","messages"})
   private Client client;   
    
   @OneToOne(cascade={CascadeType.REMOVE},mappedBy="reservation")
   @JsonIgnoreProperties("reservation")
   private Score score;

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

}
