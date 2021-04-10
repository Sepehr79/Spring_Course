package spring_course.database.springwithhibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Component;
import spring_course.database.springwithhibernate.entity.Student;

import java.util.List;

@Component("studentDao")
public class StudentDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public StudentDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void addStudent(Student student){

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();

            session.save(student);

            session.getTransaction().commit();
        }catch (Exception exception){
            exception.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
    }

    /**
     *
     * @param id select student by id
     * @return null if student not found
     */
    public Student getStudentById(int id){
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();

            Student student = session.get(Student.class, id);

            session.getTransaction().commit();

            return student;
        }catch (Exception exception){
            exception.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }

        return null;
    }

    public List<Student> getStudentsByQuery(String query){
        Session session = sessionFactory.openSession();
        List<Student> students = null;

        try {
            session.beginTransaction();

            students = session.createQuery(query).getResultList();

            session.getTransaction().commit();

            return students;
        }catch (Exception exception){
            exception.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }

        return students;
    }

    public void deleteStudent(Student student){
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            session.delete(student);

            session.getTransaction().commit();
        }catch (Exception exception){
            exception.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
    }

    public void updateStudent(Student student){
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            session.update(student);

            session.getTransaction().commit();
        }catch (Exception exception){
            exception.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
    }

    public void resetDataBase(){
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            session.createQuery("delete from Student").executeUpdate();

            session.getTransaction().commit();
        }catch (Exception exception){
            exception.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
    }

}
