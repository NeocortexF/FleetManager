package eugene.neocortex.fm.sequencer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Перечень пассажиров с привязкой к конткретному рейсу
 */

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PassengersOnBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    //связка - на каком рейсе
    private long flightId;

    private String name;

    private String place;

    public PassengersOnBoard() {
    }

    public PassengersOnBoard(long flightId, String name, String place) {
        this.flightId = flightId;
        this.name = name;
        this.place = place;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "PassengersOnBoard{" +
                "id=" + id +
                ", flightId=" + flightId +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                '}';
    }
}
