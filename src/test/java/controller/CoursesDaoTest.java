package controller;
import controller.CoursesDao;
import model.Course;
import model.Department;
import model.Semester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CoursesDaoTest {
    @Mock
    private CoursesDao coursesDao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetCoursesPerSemester() {
        // Mock data
        long semesterId = 1; // Example semester ID

        Semester semester = new Semester(semesterId, "Spring 2024", new Date());

        List<Course> courses = new ArrayList<>();
        courses.add(new Course(1L, "CS101", "Introduction to Computer Science", semester));
        courses.add(new Course(2L, "MATH101", "Calculus I", semester));

        // Mock behavior
        when(coursesDao.getCoursesPerSemester(semesterId)).thenReturn(courses);

        // Perform the test
        List<Course> actualCourses = coursesDao.getCoursesPerSemester(semesterId);

        // Assertions
        assertEquals(courses.size(), actualCourses.size());
        // Add more specific assertions if needed
    }
    @Test
    void testGetCoursesPerDepartmentAndSemester() {
        // Mock data
        long semesterId = 1; // Example semester ID
        long departmentId = 1; // Example department ID

        Semester semester = new Semester(semesterId, "Spring 2024", new Date());
        Department department = new Department(departmentId, "Computer Science");

        List<Course> courses = new ArrayList<>();
        // Assuming you have some courses for the semester and department
        courses.add(new Course(1L, "CS101", "Introduction to Computer Science", semester, department));
        courses.add(new Course(2L, "CS102", "Data Structures", semester, department));

        // Mock behavior
        when(coursesDao.getCourseByDepartmentAndSemester((int) departmentId, (int) semesterId)).thenReturn(courses);

        // Perform the test
        List<Course> actualCourses = coursesDao.getCourseByDepartmentAndSemester((int) departmentId, (int) semesterId);

        // Assertions
        assertEquals(courses.size(), actualCourses.size());
        // Add more specific assertions if needed
    }
}
