package com.example.spring.data.jpa;

import com.example.spring.data.jpa.entity.Student;
import com.example.spring.data.jpa.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringDataJpaApplicationTests {

  @Autowired private StudentRepository studentRepository;

  @Test
  public void saveStudent() {
    Student student =
        Student.builder()
            .emailId("nguyenducbao@gmail.com")
            .firstName("Bao")
            .lastName("Nguyen")
            .guardianName("Thanh")
            .guardianEmail("nguyenducthanh")
            .guardianMobile("999999999999")
            .build();

    studentRepository.save(student);
  }

  @Test
  public void printAllStudent(){
    List<Student> studentList = studentRepository.findAll();

    System.out.println("studentList = "+studentList);
  }
}
