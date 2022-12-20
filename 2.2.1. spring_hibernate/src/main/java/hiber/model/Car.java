package hiber.model;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "cars")
public class Car {

    @Id()
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private User user;

    public Car() {

    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Car(String model, int series, User user) {
        this.model = model;
        this.series = series;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return String.format("Car[id = %d, model = %s, series = %s]", id, model, series);
    }
}