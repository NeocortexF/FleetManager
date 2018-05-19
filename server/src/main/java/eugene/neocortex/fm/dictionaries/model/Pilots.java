package eugene.neocortex.fm.dictionaries.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Справочник летчиков (идут в модель Flight)
 */

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pilots {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    private String postion;

    private byte squadron;

    public Pilots() {
    }

    public Pilots(String name, String postion, byte squadron) {
        this.name = name;
        this.postion = postion;
        this.squadron = squadron;
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

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    public byte getSquadron() {
        return squadron;
    }

    public void setSquadron(byte squadron) {
        this.squadron = squadron;
    }

    @Override
    public String toString() {
        return "Pilots{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", postion='" + postion + '\'' +
                ", squadron=" + squadron +
                '}';
    }
}