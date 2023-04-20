package com.example.spring.data.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.example.spring.data.jpa.entity.Course;
import com.example.spring.data.jpa.entity.Teacher;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
class CourseRepositoryTest {
  @Autowired private CourseRepository courseRepository;

  @Test
  public void printCourses() {
    List<Course> courses = courseRepository.findAll();

    System.out.println(courses);
    System.out.println("===================");
    //    System.out.println(courses.get(0).getCourseMaterial());

  }

  @Test
  public void saveCourseWithTeacher() {
    Teacher teacher = Teacher.builder().firstName("Master").lastName("Java").build();

    Course course = Course.builder().title("Java Master").credit(6).teacher(teacher).build();

    courseRepository.save(course);
  }

  @Test
  public void findAllPagination() {
    Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
    Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

    long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();

    long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

    System.out.println("totalPages = " + totalPages);
    System.out.println("totalElements =" + totalElements);
    List<Course> courses = courseRepository.findAll(secondPageWithTwoRecords).getContent();
    System.out.println("courses = " + courses);
  }

  @Test
  public void findAllSorting() {
    Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
    Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
    Pageable sortByTitleAndCreditDesc =
        PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));
  List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
    System.out.println(courses);
  }
}
