package com.iljaust.respository.hibernate;

import com.iljaust.model.Account;
import com.iljaust.respository.AccountRepository;
import com.iljaust.util.HibernateConfig;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {

    private Transaction transaction;
    private Session session;

    @Override
    public Account getById(Long id) {
        try{
            session = HibernateConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Account account = session.get(Account.class, id);
            transaction.commit();

            return account;
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
    public Account save(Account account) {
        try{
            session = HibernateConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(account);
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
        return account;
    }

    @Override
    public Account update(Account account) {
        try{
            session = HibernateConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(account);
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
        return account;
    }

    @Override
    public List<Account> getAll() {
        try{
            session = HibernateConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Account> criteria = builder.createQuery(Account.class);
            criteria.from(Account.class);
            List<Account> accounts = session.createQuery(criteria).getResultList();

            transaction.commit();

            return accounts;

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
            Account account = session.load(Account.class, id);

            if(account != null){
                session.delete(account);
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
