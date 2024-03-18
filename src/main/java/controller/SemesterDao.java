package controller;

import model.Semester;
import model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

public class SemesterDao {
    public void saveSemester(Semester semester) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // save the student object
            session.save(semester);

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Semester getSemesterById(Long semesterId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Semester.class, semesterId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}