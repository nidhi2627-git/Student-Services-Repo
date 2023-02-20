package com.example.studentservices.repository;

import com.example.studentservices.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
//    List<Course> findCoursesByStudentId(Long studentId);
}
