package com.iljaust.respository.hibernate;

import com.iljaust.model.Skill;
import com.iljaust.respository.SkillRepository;
import com.iljaust.util.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class SkillRepositoryImpl implements SkillRepository {
    private Transaction transaction;
    private Session session;

    @Override
    public Skill getById(Long id) {
        try{
            session = HibernateConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Skill skill = session.get(Skill.class, id);
            transaction.commit();

            return skill;
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
    public Skill save(Skill skill) {
        try{
            session = HibernateConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(skill);
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
        return skill;
    }

    @Override
    public Skill update(Skill skill) {
        try{
            session = HibernateConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(skill);
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
        return skill;
    }

    @Override
    public List<Skill> getAll() {
        try{
            session = HibernateConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Skill> criteria = builder.createQuery(Skill.class);
            criteria.from(Skill.class);
            List<Skill> skills  = session.createQuery(criteria).getResultList();

            transaction.commit();

            return skills ;

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
            Skill skill = session.load(Skill.class, id);

            if(skill != null){
                session.delete(skill);
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

