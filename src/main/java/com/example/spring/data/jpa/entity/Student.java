package com.example.spring.data.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_student", uniqueConstraints = {
        @UniqueConstraint(name = "email_unique", columnNames = "email_address")
     })
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequenceName", sequenceName = "student_sequenceSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequenceName")
    private Long studentId;
    private String lastName;
    private String firstName;

    @Column(name = "email_address", unique = true, nullable = false)
    private String emailId;

    @Embedded
    private Guardian guardian;

}
