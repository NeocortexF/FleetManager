package eugene.neocortex.fm.sequencer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * Перечень груза с привязкой к конкретному рейсу
 */

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CargoOnBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    //связка - на каком рейсе
    private long flightId;

    //в каком багажнике
    private String cargoCompartment;

    private String description;

    private float weight;

    public CargoOnBoard() {
    }

    public CargoOnBoard(long flightId, String cargoCompartment, String description, int weight) {
        this.flightId = flightId;
        this.cargoCompartment = cargoCompartment;
        this.description = description;
        this.weight = weight;
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

    public String getCargoCompartment() {
        return cargoCompartment;
    }

    public void setCargoCompartment(String cargoCompartment) {
        this.cargoCompartment = cargoCompartment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "CargoOnBoard{" +
                "id=" + id +
                ", flightId=" + flightId +
                ", cargoCompartment='" + cargoCompartment + '\'' +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                '}';
    }
}
