package com.andrewsmv.taskmanagerapp.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "note")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Note extends DateStatistic {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_id_seq")
    @SequenceGenerator(name = "note_id_seq", sequenceName = "note_id_seq", allocationSize = 1)
    @Column
    private Long id;

    @Column
    private String title;

    @Column
    private String text;

    @Column
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;
}
