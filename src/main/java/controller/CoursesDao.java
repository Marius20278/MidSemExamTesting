package controller;

import model.Course;
import model.Semester;
import model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class CoursesDao {
    public void saveCourse(Course course) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // save the student object
            session.save(course);

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Course> getCoursesPerSemester(long semesterId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT c FROM Course c WHERE c.semester.semesterId = :semesterId";
            Query<Course> query = session.createQuery(hql, Course.class);
            query.setParameter("semesterId", semesterId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Course> getCourseByDepartmentAndSemester(int departmentId, int semesterId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT c FROM Course c WHERE c.semester.semesterId = :semesterId AND c.department.departmentId = :departmentId";
            Query<Course> query = session.createQuery(hql, Course.class);
            query.setParameter("departmentId", departmentId);
            query.setParameter("semesterId", semesterId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Course getCourseById(Long courseId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Course.class, courseId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
