package com.andrewsmv.taskmanagerapp.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@FieldNameConstants
@Data
public class DateStatistic {

    @Column
    @CreationTimestamp
    private LocalDate createdDate;

    @Column
    @UpdateTimestamp
    private LocalDate lastModifiedDate;
}
