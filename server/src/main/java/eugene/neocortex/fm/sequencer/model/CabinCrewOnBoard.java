package eugene.neocortex.fm.sequencer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Перечень бортпроводников с привязкой к конкретному рейсу
 */

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CabinCrewOnBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    //связка - на каком рейсе
    private long flightId;

    private String name;

    private String position;

    public CabinCrewOnBoard() {
    }

    public CabinCrewOnBoard(long flightId, String name, String position) {
        this.flightId = flightId;
        this.name = name;
        this.position = position;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "CabinCrewOnBoard{" +
                "id=" + id +
                ", flightId=" + flightId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
