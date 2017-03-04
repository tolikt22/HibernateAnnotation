package terela.com.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "buses")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bus_id")
    private Long id;
    @Column(name = "number")
    private String number;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "bus_driver",
            joinColumns = {@JoinColumn(name = "bus_id",
                    nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "driver_id",
                    nullable = false, updatable = false)})
    private Set<Driver> drivers = new HashSet();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    public Bus() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", drivers=" + drivers +
                ", route=" + route +
                '}';
    }
}
