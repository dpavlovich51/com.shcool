package com.school.student.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.util.UUID;

@Data
@Builder
@Entity
@FieldNameConstants
@Table(name = "students")
public class StudentEntity {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String course;

}
