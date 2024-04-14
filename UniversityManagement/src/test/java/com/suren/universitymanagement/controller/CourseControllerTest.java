package com.suren.universitymanagement.controller;

import com.suren.universitymanagement.model.Course;
import com.suren.universitymanagement.service.CourseService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CourseControllerTest {

    @Mock
    private CourseService courseService;

    @InjectMocks
    private CourseController courseController;

    public CourseControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllCourses() {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(1L, "Math"));
        courses.add(new Course(2L, "Science"));
        when(courseService.getAllCourses()).thenReturn(courses);

        List<Course> result = courseController.getAllCourses();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetCourseById() {
        Long courseId = 1L;
        Course course = new Course(courseId, "Math");
        when(courseService.getCourseById(courseId)).thenReturn(Optional.of(course));

        Course result = courseController.getCourseById(courseId);

        assertEquals(courseId, result.getId());
    }

    @Test
    public void testCreateCourse() {
        Course course = new Course(1L, "Math");
        when(courseService.createCourse(course)).thenReturn(course);

        Course result = courseController.createCourse(course);

        assertEquals(course.getName(), result.getName());
    }

    @Test
    public void testUpdateCourse() {
        Long courseId = 1L;
        Course existingCourse = new Course(courseId, "Math");
        Course updatedCourseData = new Course(courseId, "Science");
        when(courseService.updateCourse(courseId, updatedCourseData)).thenReturn(updatedCourseData);

        Course result = courseController.updateCourse(courseId, updatedCourseData);

        assertEquals(updatedCourseData.getName(), result.getName());
    }

    @Test
    public void testDeleteCourse() {
        Long courseId = 1L;
        ResponseEntity<?> expectedResponse = new ResponseEntity<>(HttpStatus.OK);
        doNothing().when(courseService).deleteCourse(courseId);

        ResponseEntity<?> result = courseController.deleteCourse(courseId);

        assertEquals(expectedResponse.getStatusCode(), result.getStatusCode());
    }
}
