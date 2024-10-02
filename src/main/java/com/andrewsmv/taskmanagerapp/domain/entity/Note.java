package com.andrewsmv.taskmanagerapp.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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
    private Category category;
}
