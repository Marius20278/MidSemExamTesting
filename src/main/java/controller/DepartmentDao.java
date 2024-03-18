package controller;

import model.Department;
import model.Semester;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

public class DepartmentDao {

    public void saveDepartment(Department department) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // save the department object
            session.save(department);

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Department getDepartmentById(Long departmentId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Department.class, departmentId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}