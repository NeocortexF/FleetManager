package eugene.neocortex.fm.dictionaries.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Справочник аэропортов
 */

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Airports {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    private String codeICAO;

    public Airports() {
    }

    public Airports(String name, String codeICAO) {
        this.name = name;
        this.codeICAO = codeICAO;
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

    public String getCodeICAO() {
        return codeICAO;
    }

    public void setCodeICAO(String codeICAO) {
        this.codeICAO = codeICAO;
    }

    @Override
    public String toString() {
        return "Airports{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", codeICAO='" + codeICAO + '\'' +
                '}';
    }
}
