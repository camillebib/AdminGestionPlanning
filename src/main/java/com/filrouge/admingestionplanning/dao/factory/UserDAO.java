package com.filrouge.admingestionplanning.dao.factory;

import com.filrouge.admingestionplanning.dao.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAO implements Dao<User> {

    @Override
    public Optional<User> get(Long id) {
        Optional<User> result = Optional.empty();
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            result = Optional.of(em.find(User.class, id));
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return result;
    }

    @Override
    public Optional<User> get(String pseudo) {
        Optional<User> result = Optional.empty();
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            result = Optional.of(em.createQuery(
                    "SELECT u from User u WHERE u.pseudo = :pseudo", User.class).
                    setParameter("pseudo", pseudo).getSingleResult());
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return result;
    }

    @Override
    public List<User> getAll() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        List<User> users = new ArrayList<>();
        et.begin();
        try {
            TypedQuery<User> usersQuery = em.createQuery("SELECT u FROM User u", User.class);
            users = usersQuery.getResultList();
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return users;
    }

    @Override
    public void create(User user) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.persist(user);
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }

    }

    @Override
    public void update(User user) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.merge(user);
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }

    }

    @Override
    public void delete(User user) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.remove(em.contains(user) ? user : em.merge(user));
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }

    }

    public boolean validate(String pseudo, String password, HttpServletRequest request) {

        Transaction transaction = null;
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            user = (User) session.createQuery("FROM User U WHERE U.pseudo = :pseudo").setParameter("pseudo", pseudo)
                    .uniqueResult();

            if (user != null && user.getPassword().equals(password)) {
                request.getSession().setAttribute("user", user);
                return true;
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }
}