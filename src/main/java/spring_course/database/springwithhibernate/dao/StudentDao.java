package spring_course.database.springwithhibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring_course.database.springwithhibernate.entity.Student;

import java.util.List;

@Component("studentDao")
@Repository
@Transactional
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
        Session session = sessionFactory.getCurrentSession();

        session.save(student);
    }

    public List<Student> getStudents(){
        Session session = sessionFactory.getCurrentSession();

        List<Student> students = session.createQuery("from Student").getResultList();

        return students;
    }

    /**
     *
     * @param id select student by id
     * @return null if student not found
     */
    public Student getStudentById(int id){
        Session session = sessionFactory.getCurrentSession();

        Student student = session.get(Student.class, id);

        return student;
    }

    public List<Student> getStudentsByQuery(String query){
        Session session = sessionFactory.getCurrentSession();

        List<Student> students = session.createQuery(query).getResultList();

        return students;
    }

    public Student getStudentByQuery(String hql){
        Session session = sessionFactory.getCurrentSession();

        Student student = (Student) session.createQuery(hql).uniqueResult();

        return student;
    }

    public void deleteStudent(Student student){
        Session session = sessionFactory.getCurrentSession();

        session.delete(student);
    }

    public void updateStudent(Student student){
        Session session = sessionFactory.getCurrentSession();

        session.update(student);
    }

    public void resetDataBase(){
        Session session = sessionFactory.getCurrentSession();

        session.createQuery("delete from Student").executeUpdate();
    }

}
