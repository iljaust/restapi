package com.iljaust.respository.hibernate;


import com.iljaust.model.Developer;
import com.iljaust.respository.DeveloperRepository;
import com.iljaust.util.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.transaction.Transactional;

import java.util.List;


public class DeveloperRepositoryImpl implements DeveloperRepository {

    private Session session;
    @Transactional
    @Override

    public Developer getById(Long id) {
        try{
            String q = "FROM Developer d LEFT JOIN FETCH d.skillSet WHERE d.id = :id";

            session = HibernateConfig.getSessionFactory().openSession();
            Query query = session.createQuery(q);
            query.setParameter("id", id);

            return (Developer) query.getSingleResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return null;
    }

    @Transactional
    @Override
    public Developer save(Developer developer) {
        try{
            session = HibernateConfig.getSessionFactory().openSession();
            session.save(developer);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return developer;
    }

    @Transactional
    @Override
    public Developer update(Developer developer) {
        try{
            session = HibernateConfig.getSessionFactory().openSession();
            session.update(developer);
        }
        catch (Exception e){
             e.printStackTrace();
        }
        finally {
            session.close();
        }
        return developer;
    }

    @Transactional
    @Override
    public List<Developer> getAll() {
        try{
            session = HibernateConfig.getSessionFactory().openSession();
            final String hql = "FROM Developer d LEFT JOIN FETCH d.skillSet";

            @SuppressWarnings("unchecked")
            List<Developer> developers = session.createQuery(hql).list();
            return developers;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return null;
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        try{
            session = HibernateConfig.getSessionFactory().openSession();
            Developer developer = session.load(Developer.class, id);

            if(developer != null){
                session.delete(developer);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }
}

