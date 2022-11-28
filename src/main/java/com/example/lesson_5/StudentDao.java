package com.example.lesson_5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDao {
    private final SessionFactory factory;

    public StudentDao() {
        this.factory = Factory.getFactory();
    }

    public void add(Student student) {
        try (Session session = factory.getCurrentSession()){
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        }
    }

    public int getMark (int id) {
        try (Session session = factory.getCurrentSession()){
            int mark;
            session.beginTransaction();
            mark = session.find(Student.class, id).getMark();
            session.getTransaction().commit();
            return mark;
        }
    }

    public Student getName (int id) {
        try (Session session = factory.getCurrentSession()){
            Student student;
            session.beginTransaction();
            student = session.find(Student.class, id);
            session.getTransaction().commit();
            return student;
        }
    }

    public List<Student> getAll () {
        List<Student> students;
        try (Session session = factory.getCurrentSession()){
            session.beginTransaction();
            students = session.createQuery("from Student").getResultList();
            session.getTransaction().commit();
            return students;
        }
    }

    public void delete (int id) {
        try (Session session = factory.getCurrentSession()){
            session.beginTransaction();
            Query query = session.createQuery("delete from Student s where s.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }

    public void delete (String name) {
        try (Session session = factory.getCurrentSession()){
            session.beginTransaction();
            Query query = session.createQuery("delete from Student s where s.name = :name");
            query.setParameter("name", name);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }

    public void update (Student student) {
        try (Session session = factory.getCurrentSession()){
            session.beginTransaction();
            session.saveOrUpdate(student);
            session.getTransaction().commit();
        }
    }

    public void closeSessionFactory() {
        factory.close();
    }






}
