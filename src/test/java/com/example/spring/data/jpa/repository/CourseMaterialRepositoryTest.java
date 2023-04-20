package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Course;
import com.example.spring.data.jpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

  @Autowired private CourseMaterialRepository courseMaterialRepository;

  @Test
  public void saveCourseMaterial() {
    Course course = Course.builder().title("DSA").credit(6).build();
    CourseMaterial courseMaterial =
        CourseMaterial.builder().url("www.google.com").courseObj(course).build();
    courseMaterialRepository.save(courseMaterial);
  }

  @Test
  public void deleteCourseMaterial() {
    Course course = Course.builder().title("DSA").credit(6).build();
    CourseMaterial courseMaterial =
        CourseMaterial.builder().url("www.google.com").courseMaterialId(4L).courseObj(course).build();
    courseMaterialRepository.delete(courseMaterial);
  }

  @Test
  public void printAllCourseMaterials() {
    List<CourseMaterial> courseMaterialList = courseMaterialRepository.findAll();
    System.out.println(courseMaterialList);
  }
}
