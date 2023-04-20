package com.example.spring.data.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "courseObj")
public class CourseMaterial {

  @Id
  @SequenceGenerator(
      name = "course_material_name",
      sequenceName = "course_material_sequence",
      allocationSize = 2)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_material_name")
  private Long courseMaterialId;

  private String url;

  @OneToOne(
          cascade = CascadeType.ALL,
          fetch = FetchType.LAZY
  )
  @JoinColumn(
          name = "course_id",
          referencedColumnName = "courseId"
  )
  private Course courseObj;
}
