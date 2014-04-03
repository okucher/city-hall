package com.opencouncil.hibernate.example.dao;

import com.opencouncil.hibernate.example.dto.Test;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class TestDAO {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:com/opencouncil/applicationContext.xml");
        Map<String, SessionFactory> sf = context.getBeansOfType(SessionFactory.class);
        System.out.println(sf.size());
    }
    
    
    @Resource(name="sessionFactory")
    SessionFactory sessionFactory;

    protected Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    
    public void create(Test testObj) {
        Session session = getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(testObj);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public Test readById(int id) {
        Session session = getCurrentSession();
        Transaction transaction = null;
        Test test = null;
        try {
            transaction = session.beginTransaction();
            String queryString = "from Test where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            test = (Test) query.uniqueResult();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return test;
    }
    
    public List<Test> readAll() {
        List<Test> testList = new ArrayList<Test>();
        Session session = getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            testList = session.createQuery("from Test").list();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return testList;
    }
    
    public void update(Test updateObj) {
        Session session = getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(updateObj);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    public void delete(String id) {
        Session session = getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Test test = (Test)session.load(Test.class, new Integer(id));
            session.delete(test);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
