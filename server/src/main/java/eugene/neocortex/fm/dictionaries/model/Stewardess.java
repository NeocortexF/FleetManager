package eugene.neocortex.fm.dictionaries.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Справочник бортпроводников (идут в модель CabinCrewOnBoard)
 */

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Stewardess {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    private String position;

    //Номер отряда
    private byte brigade;

    public Stewardess() {
    }

    public Stewardess(String name, String position, byte brigade) {
        this.name = name;
        this.position = position;
        this.brigade = brigade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public byte getBrigade() {
        return brigade;
    }

    public void setBrigade(byte brigade) {
        this.brigade = brigade;
    }

    @Override
    public String toString() {
        return "Stewardess{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", brigade=" + brigade +
                '}';
    }
}
