package com.example.studentservices.controller;

import com.example.studentservices.model.Student;
import com.example.studentservices.repository.CourseRepository;
import com.example.studentservices.model.Course;
import com.example.studentservices.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.studentservices.exception.ApiExceptionHandler.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        if (courses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @PostMapping("/students/{studentId}/courses")
    public ResponseEntity<Course> addCourse(@PathVariable(value = "studentId") Long studentId, @RequestBody Course courseRequest) {
        Course course = studentRepository.findById(studentId).map(student -> {
            Long courseId = courseRequest.getId();

            //course is existed
            if(courseId != null) {
                Course _course = courseRepository.findById(Math.toIntExact(courseId))
                        .orElseThrow(() -> new RuntimeException("Not found Course with id = " + courseId));
                student.addCourse(_course);
                studentRepository.save(student);
                return _course;
            }

            // add and create new Course
            student.addCourse(courseRequest);
            return courseRepository.save(courseRequest);
        }).orElseThrow(() -> new RuntimeException("Not found Student with id = " + studentId));

        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }
}
