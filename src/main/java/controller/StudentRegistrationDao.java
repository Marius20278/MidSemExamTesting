package controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Student;
import model.StudentRegistration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class StudentRegistrationDao {

    private EntityManager entityManager;

    public void StudentRegistration(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void studentRegistration(StudentRegistration studentRegistration) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // save reg object
            session.save(studentRegistration);

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Student> getStudentsPerCourse(long courseId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT sr.student FROM StudentRegistration sr WHERE sr.course.courseId = :courseId";
            Query<Student> query = session.createQuery(hql, Student.class);
            query.setParameter("courseId", courseId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Student> getStudentsPerSemester(long semesterId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT sr.student FROM StudentRegistration sr WHERE sr.semester.semesterId = :semesterId";
            Query<Student> query = session.createQuery(hql, Student.class);
            query.setParameter("semesterId", semesterId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Student> getStudentsByDepartmentAndSemester(int departmentId, int semesterId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT sr.student FROM StudentRegistration sr WHERE sr.semester.semesterId = :semesterId AND sr.department.departmentId = :departmentId";
            Query<Student> query = session.createQuery(hql, Student.class);
            query.setParameter("departmentId", departmentId);
            query.setParameter("semesterId", semesterId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        }
    }

