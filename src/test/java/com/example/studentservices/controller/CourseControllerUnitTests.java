package com.example.studentservices.controller;

import com.example.studentservices.model.Course;
import com.example.studentservices.repository.CourseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CourseController.class)
public class CourseControllerUnitTests {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    CourseRepository courseRepository;

    Course mockCourse1 = new Course(1L, "CourseA :JAVA", "OOPS Concepts");
    Course mockCourse2 = new Course(2L, "CourseB :Python", "Advanced Concepts");

//    @Test
//    public void getAllCourses_success() throws Exception {
//        List<Course> courseList = new ArrayList<>(Arrays.asList(mockCourse1, mockCourse2));
//
//        Mockito.when(courseRepository.findAll()).thenReturn(courseList);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                .get("/courses")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect((ResultMatcher) jsonPath("$[0].name", is("CourseA :JAVA")))
//                .andExpect((ResultMatcher) jsonPath("$[1].description", is("Advanced Concepts")));
//    }

//    @Test
//    public void createCourse_success() throws Exception {
//        Mockito.when(courseRepository.save(mockCourse1)).thenReturn(mockCourse1);
//
//        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/courses")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(this.objectMapper.writeValueAsString(mockCourse1));
//
//        mockMvc.perform(mockRequest)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", notNullValue()))
//                .andExpect((ResultMatcher) jsonPath("$", is("New Course created successfully")));
//    }
}
