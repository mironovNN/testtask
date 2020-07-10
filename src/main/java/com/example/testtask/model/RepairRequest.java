package com.example.testtask.model;

import org.springframework.data.annotation.Id;
import javax.persistence.*;

@Entity
@Table(name = "request")
public class RepairRequest {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "requestIdSeq", sequenceName = "request_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "requestIdSeq")
    private int id;

    @Column(name = "idUser")
    private int idUser;

    @Column(name = "description")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RepairRequest(int id, int idUser, String description) {
        this.id = id;
        this.idUser = idUser;
        this.description = description;
    }
}