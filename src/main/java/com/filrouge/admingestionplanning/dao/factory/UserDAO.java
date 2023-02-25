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
    public List<User> getAll( int role) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        List<User> users = new ArrayList<>();
        et.begin();
        try {
            TypedQuery<User> usersQuery = null;
            if (role == 2) {
                usersQuery = em.createQuery("SELECT u FROM User u", User.class);
            } else {
                usersQuery = em.createQuery("SELECT u FROM User u JOIN u.roles r WHERE r.id = 1", User.class);
            }
            users = usersQuery.getResultList();
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
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
            e.printStackTrace();
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

    public boolean validate(String email, String password, HttpServletRequest request) {

        Transaction transaction = null;
        User user;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            user = session.createQuery("FROM User U WHERE U.email = :email", User.class).setParameter("email", email)
                    .uniqueResult();

            if (user != null && user.getPassword().equals(password)) {
                request.getSession().setAttribute("user", user);
                return true;
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}