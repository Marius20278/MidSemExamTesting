package  controller;
import controller.StudentRegistrationDao;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class StudentRegistrationDaoTest {
    @Mock
    private StudentRegistrationDao studentRegistrationDao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetStudentsPerSemester() {
        // Mock data
        long semesterId = 1;
        Semester semester = new Semester(semesterId, "Spring 2024", new Date());

        List<StudentRegistration> registrations = new ArrayList<>();
        registrations.add(new StudentRegistration(1, "ABC123", new Date(), new Student(), semester, null));

        List<Student> expectedStudents = new ArrayList<>();
        for (StudentRegistration registration : registrations) {
            expectedStudents.add(registration.getStudent());
        }

        when(studentRegistrationDao.getStudentsPerSemester(semesterId)).thenReturn(expectedStudents);
        List<Student> actualStudents = studentRegistrationDao.getStudentsPerSemester(semesterId);
        assertEquals(expectedStudents.size(), actualStudents.size());
    }

@Test
    void testGetStudentsPerDepartmentAndSemester() {
        // Mock data
        long semesterId = 1L;
        long departmentId = 1L;

        Semester semester = new Semester(semesterId, "Spring 2024", new Date());
        Department department = new Department(departmentId, "Computer Science");

        List<StudentRegistration> registrations = new ArrayList<>();
        // Assuming you have some registrations for the semester and department
        registrations.add(new StudentRegistration(1, "ABC123", new Date(), new Student(), semester, department));

        List<Student> expectedStudents = new ArrayList<>();
        for (StudentRegistration registration : registrations) {
            expectedStudents.add(registration.getStudent());
        }

        when(studentRegistrationDao.getStudentsByDepartmentAndSemester((int) departmentId, (int) semesterId)).thenReturn(expectedStudents);
        List<Student> actualStudents = studentRegistrationDao.getStudentsByDepartmentAndSemester((int) departmentId, (int) semesterId);

        assertEquals(expectedStudents.size(), actualStudents.size());

    }
}
