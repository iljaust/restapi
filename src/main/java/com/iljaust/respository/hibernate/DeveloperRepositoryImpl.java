package com.iljaust.respository.hibernate;

import com.iljaust.model.Account;
import com.iljaust.model.AccountStatus;
import com.iljaust.model.Developer;
import com.iljaust.model.Skill;
import com.iljaust.respository.DeveloperRepository;
import com.iljaust.util.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class DeveloperRepositoryImpl implements DeveloperRepository {

    private Transaction transaction;
    private Session session;
    @Override
    public Developer getById(Long id) {
        try{
            session = HibernateConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Developer developer = session.get(Developer.class, id);
            transaction.commit();

            return developer;
        }
        catch (Exception e){
            if(transaction != null)
                transaction.rollback();

            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return null;
    }

    @Override
    public Developer save(Developer developer) {
        try{
            session = HibernateConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(developer);
            transaction.commit();
        }
        catch (Exception e){
            if(transaction != null)
                transaction.rollback();

            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return developer;
    }

    @Override
    public Developer update(Developer developer) {
        try{
            session = HibernateConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(developer);
            transaction.commit();
        }
        catch (Exception e){
            if(transaction != null)
                transaction.rollback();

            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return developer;
    }

    @Override
    public List<Developer> getAll() {
        try{
            session = HibernateConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Developer> criteria = builder.createQuery(Developer.class);
            criteria.from(Developer.class);
            List<Developer> developers  = session.createQuery(criteria).getResultList();

            transaction.commit();

            return developers;

        }
        catch (Exception e){
            if(transaction != null)
                transaction.rollback();

            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        try{
            session = HibernateConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Developer developer = session.load(Developer.class, id);

            if(developer != null){
                session.delete(developer);
            }

            transaction.commit();

        }
        catch (Exception e){
            if(transaction != null)
                transaction.rollback();

            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }
}

