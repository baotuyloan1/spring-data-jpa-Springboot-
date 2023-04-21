package com.example.spring.data.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
  @Id
  @SequenceGenerator(
      name = "course_sequence_name",
      sequenceName = "course_sequence",
      allocationSize = 3)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence_name")
  private Long courseId;

  private String title;
  private int credit;

  @OneToOne(mappedBy = "courseObj", fetch = FetchType.LAZY)
  private CourseMaterial courseMaterial;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
  private Teacher teacher;

  @ManyToMany(
          cascade = CascadeType.PERSIST
  )
  @JoinTable(
      name = "tblStudentCourse",
      joinColumns = @JoinColumn(name = "courseIdDatabase", referencedColumnName = "courseId"),
      inverseJoinColumns =
          @JoinColumn(name = "studentIdDatabase", referencedColumnName = "studentId"))
  private List<Student> students;

  public void addStudents(Student student) {
    if (students == null) students = new ArrayList<>();
    students.add(student);
  }
}
