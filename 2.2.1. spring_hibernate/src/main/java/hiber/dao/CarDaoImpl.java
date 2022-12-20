package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository
public class CarDaoImpl implements CarDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public CarDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    @SuppressWarnings("unchecked")
    public User getUser(String model, int series) {
        String HQL = "FROM User WHERE id = (SELECT id FROM Car WHERE model = :model AND series = :series)";

        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(HQL);
        query.setParameter("model", model);
        query.setParameter("series", series);
        return query.getSingleResult();
    }
}