package com.antriksh1994.cruddemo.dao;

import com.antriksh1994.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Transactional
    @Override
    public void save(Student thestudent) {
        // persist is used to insert objects to db
        entityManager.persist(thestudent);
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student WHERE lastName=:theData", Student.class);
        theQuery.setParameter("theData", theLastName);
        System.out.println(theLastName);
        return theQuery.getResultList();
        // TypedQuery<Student> theQuery = entityManager.createQuery("From Student order by lastName", Student.class);
        // return query results
        // return theQuery.getResultList();
    }
    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student", Student.class);
        // TypedQuery<Student> theQuery = entityManager.createQuery("From Student order by lastName", Student.class);
        // return query results
        return theQuery.getResultList();
    }
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }
    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student thStudent = entityManager.find(Student.class, id);
        entityManager.remove(thStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}
