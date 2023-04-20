package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  List<Student> findByFirstName(String firstName);

  List<Student> findByFirstNameContaining(String name);

  List<Student> findByLastNameNotNull();

  List<Student> findByGuardianNameIgnoreCase(String guardianName);

  List<Student> findDistinctByLastNameAndFirstName(String lastName, String name);
  //  JPQL
  @Query("select s from Student s where s.emailId = ?1")
  Student getStudentByEmailAddress(String emailId);

  //  JPQL
  @Query("select s.firstName from Student s where s.emailId = :emailId")
  String getStudentFirstNameByEmailAddress(@Param("emailId") String emailId);

  //  Native Query
  @Query(value = "SELECT * FROM tbl_student s WHERE s.email_address = ?1", nativeQuery = true)
  Student getStudentByEmailAddressNative(String emailId);

//  Native Named Param
  @Query(value = "SELECT * FROM tbl_student s WHERE s.email_address = :emailId", nativeQuery = true)
  Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);


  @Transactional
  @Modifying
  @Query(
          value = "update tbl_student set first_name = :firstName where email_address = :emailId",
          nativeQuery = true
  )

  int updateStudentNameByEmailId(@Param("firstName") String firstName,@Param("emailId") String emailId);


  @Transactional
  @Modifying
  @Query(
          value = "delete FROM tbl_student WHERE email_address = :emailId",
          nativeQuery = true
  )
  int deleteStudentByEmailId(@Param("emailId") String emailId);


}
