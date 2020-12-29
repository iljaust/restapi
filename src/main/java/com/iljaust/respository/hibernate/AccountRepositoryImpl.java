package com.iljaust.respository.hibernate;

import com.iljaust.model.Account;
import com.iljaust.respository.AccountRepository;
import com.iljaust.util.HibernateConfig;

import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {
    private Session session;

    @Transactional
    @Override
    public Account getById(Long id) {
        try{
            session = HibernateConfig.getSessionFactory().openSession();

            return session.get(Account.class, id);
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
    public Account save(Account account) {
        try{
            session = HibernateConfig.getSessionFactory().openSession();
            session.save(account);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return account;
    }

    @Transactional
    @Override
    public Account update(Account account) {
        try{
            session = HibernateConfig.getSessionFactory().openSession();
            session.update(account);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return account;
    }

    @Transactional
    @Override
    public List<Account> getAll() {
        try{
            session = HibernateConfig.getSessionFactory().openSession();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Account> criteria = builder.createQuery(Account.class);
            criteria.from(Account.class);

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
            Account account = session.load(Account.class, id);

            if(account != null){
                session.delete(account);
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
