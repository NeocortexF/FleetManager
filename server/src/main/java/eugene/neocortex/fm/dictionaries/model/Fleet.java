package eugene.neocortex.fm.dictionaries.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Модель данных флота
 * tailNumber используется для связки, например deadlines
 */

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Fleet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String tailNumber;

    private String modification;

    private String engineType;

    private int msn;

    public Fleet() {
    }

    public Fleet(String tailNumber, String modification, String engineType, int msn) {
        this.tailNumber = tailNumber;
        this.modification = modification;
        this.engineType = engineType;
        this.msn = msn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTailNumber() {
        return tailNumber;
    }

    public void setTailNumber(String tailNumber) {
        this.tailNumber = tailNumber;
    }

    public String getModification() {
        return modification;
    }

    public void setModification(String modification) {
        this.modification = modification;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public int getMsn() {
        return msn;
    }

    public void setMsn(int msn) {
        this.msn = msn;
    }

    @Override
    public String toString() {
        return "Fleet{" +
                "id=" + id +
                ", tailNumber='" + tailNumber + '\'' +
                ", modification='" + modification + '\'' +
                ", engineType='" + engineType + '\'' +
                ", msn=" + msn +
                '}';
    }
}
