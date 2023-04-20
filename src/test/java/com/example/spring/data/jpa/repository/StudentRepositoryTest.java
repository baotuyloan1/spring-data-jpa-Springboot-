package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Guardian;
import com.example.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

  @Autowired private StudentRepository studentRepository;

  @Test
  @Disabled
  public void saveStudent() {
    Student student =
        Student.builder()
            .emailId("nguyenducbao@gmail.com")
            .firstName("Bao")
            .lastName("Nguyen")
            //                        .guardianName("Thanh")
            //                        .guardianEmail("nguyenducthanh")
            //                        .guardianMobile("999999999999")
            .build();

    studentRepository.save(student);
  }

  @Test
  public void saveStudentWithGuardian() {

    Guardian guardian =
        Guardian.builder().name("Thanh").email("thanh@gmail.com").mobile("2132512351").build();

    Student student =
        Student.builder()
            .emailId("nguyenducbao3@gmail.com")
            .firstName("Bao 3")
            .lastName("Nguyen 3")
            .guardian(guardian)
            .build();

    studentRepository.save(student);
  }

  @Test
  public void printAllStudent() {
    List<Student> studentList = studentRepository.findAll();

    System.out.println("studentList = " + studentList);
  }

  @Test
  public void printStudentByFirstName() {
    List<Student> students = studentRepository.findByFirstName("Bao");
    System.out.println(students);
  }

  @Test
  public void printStudentByFirstNameContaining() {
    List<Student> students = studentRepository.findByFirstNameContaining("1");
    System.out.println(students);
  }

  @Test
  public void printStudentBasedOnGuardianName() {
    List<Student> students = studentRepository.findByGuardianNameIgnoreCase("thanh");
    System.out.println("students= " + students);
  }

  @Test
  public void printStudentByLastNameAndFirstName() {
    List<Student> students = studentRepository.findDistinctByLastNameAndFirstName("Nguyen", "Bao");
    System.out.println("students= " + students);
  }

  @Test
  public void printGetStudentByEmailAddress() {
    Student student = studentRepository.getStudentByEmailAddress("nguyenducbao2@gmail.com");
    System.out.println(student);
  }

  @Test
  public void printGetStudentFirstNameByEmailAddress() {
    System.out.println(
        studentRepository.getStudentFirstNameByEmailAddress("nguyenducbao2@gmail.com"));
  }

  @Test
  public void printGetStudentByEmailAddressNative() {
    System.out.println(studentRepository.getStudentByEmailAddressNative("nguyenducbao2@gmail.com"));
  }

  @Test
  public void printGetStudentByEmailAddressNativeNamedParam(){
    System.out.println(studentRepository.getStudentByEmailAddressNativeNamedParam("nguyenducbao@gmail.com"));
  }

  @Test
  public void updateStudentNameByEmailId(){
    System.out.println(studentRepository.updateStudentNameByEmailId("Nguyen Duc Bao","nguyenducbao3@gmail.com"));
  }

  @Test
  public void deleteStudentByEmailId(){
    System.out.println(studentRepository.deleteStudentByEmailId("nguyenducbao2@gmail.com"));
  }
}
