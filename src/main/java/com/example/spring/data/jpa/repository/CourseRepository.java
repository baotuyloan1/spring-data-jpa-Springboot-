package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Course;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    Page<Course> findByTitleContaining(String title, Pageable pageRequest);
}
