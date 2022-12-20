package hiber.service;

import hiber.dao.CarDao;

import hiber.model.Car;
import hiber.model.User;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    private final CarDao carDao;

    @Autowired
    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Transactional
    @Override
    public void add(Car car) {
        carDao.add(car);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(String model, int series) {
        return carDao.getUser(model, series);
    }
}