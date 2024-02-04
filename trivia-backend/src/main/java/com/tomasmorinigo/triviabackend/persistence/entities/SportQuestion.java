package com.tomasmorinigo.triviabackend.persistence.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "deportes")
public class SportQuestion{

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

    // Lista para agrupar las opciones
    private List<String> options;

    // Método ejecutado después de cargar la entidad desde la base de datos
    @PostLoad
    private void loadOptions() {
        options = new ArrayList<>();
        options.add(answer);
        options.add(incorrect1);
        options.add(incorrect2);
        options.add(incorrect3);
    }
}
