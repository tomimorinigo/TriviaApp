package com.tomasmorinigo.triviabackend.persistence.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "entretenimiento")
public class EntertainmentQuestion implements Serializable{

    private final static long serialVersionUID = 1L;

    @Id
    private Long id;
    @Column(name = "pregunta")
    private String question;
    @Column(name = "respuesta")
    private String answer;
    @Column(name = "incorrecta1")
    private String incorrect1;
    @Column(name = "incorrecta2")
    private String incorrect2;
    @Column(name = "incorrecta3")
    private String incorrect3;
}
