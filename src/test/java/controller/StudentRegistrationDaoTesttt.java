package controller;

import model.Department;
import model.Semester;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import utils.HibernateUtil;

import static org.junit.jupiter.api.Assertions.*;

class StudentRegistrationDaoTesttt {
    private static SessionFactory sessionFactory;
    private Session session;

    @BeforeAll
    public static void setup() {
        sessionFactory = HibernateUtil.getSessionFactory();
        System.out.println("SessionFactory created");
    }

    @BeforeEach
    public void initSession() {
        session = sessionFactory.openSession();
        System.out.println("Session initialized");
    }

    @AfterEach
    public void closeSession() {
        if (session != null) session.close();
        System.out.println("Session closed");
    }

    @AfterAll
    public static void tearDown() {
        if (sessionFactory != null) sessionFactory.close();
        System.out.println("SessionFactory destroyed");
    }

    @Test
    void getStudentsPerSemester() {
        Long semesterId = 1L; // Change this to the ID you want to test

        // Instantiate your DAO
        SemesterDao semesterDAO = new SemesterDao();

        // Call the method being tested
        Semester semester = semesterDAO.getSemesterById(semesterId);

        // Verify that the returned semester is not null
        assertNotNull(semester);
        assertEquals(semesterId, semester.getSemesterId());

    }
    @Test
    void getStudentsPerSemesterDepartment() {
        Long semesterId = 1L;
        Long departmentId = 1L;

        // Instantiate your DAO
        SemesterDao semesterDAO = new SemesterDao();
        DepartmentDao departmentDao = new DepartmentDao();

        // Call the method being tested
        Semester semester = semesterDAO.getSemesterById(semesterId);
        Department department = departmentDao.getDepartmentById(departmentId);

        // Verify that the returned semester is not null
        assertNotNull(semester);
        assertEquals(semesterId, semester.getSemesterId());

    }

}
