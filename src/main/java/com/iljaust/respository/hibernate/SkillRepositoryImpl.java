package com.iljaust.respository.hibernate;

import com.iljaust.model.Skill;
import com.iljaust.respository.SkillRepository;
import com.iljaust.util.HibernateConfig;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

public class SkillRepositoryImpl implements SkillRepository {
    private Session session;

    @Transactional
    @Override
    public Skill getById(Long id) {
        try{
            session = HibernateConfig.getSessionFactory().openSession();

            return session.get(Skill.class, id);
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
    public Skill save(Skill skill) {
        try{
            session = HibernateConfig.getSessionFactory().openSession();
            session.save(skill);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return skill;
    }

    @Transactional
    @Override
    public Skill update(Skill skill) {
        try{
            session = HibernateConfig.getSessionFactory().openSession();
            session.update(skill);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return skill;
    }

    @Transactional
    @Override
    public List<Skill> getAll() {
        try{
            session = HibernateConfig.getSessionFactory().openSession();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Skill> criteria = builder.createQuery(Skill.class);
            criteria.from(Skill.class);

            return session.createQuery(criteria).getResultList();

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
            Skill skill = session.load(Skill.class, id);

            if(skill != null){
                session.delete(skill);
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

