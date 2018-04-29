package eugene.neocortex.fm.sequencer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Модель данных для одного дедлайна,
 * что бы передавать объект в спискок дедлайнов
 * Перечень дедлайнов для одного борта
 */

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OneDeadline {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String tailNumber;

    private Date deadline;

    private String description;

    public OneDeadline() {
    }

    public OneDeadline(Date deadline, String description, String tailNumber) {
        this.deadline = deadline;
        this.description = description;
        this.tailNumber = tailNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTailNumber() {
        return tailNumber;
    }

    public void setTailNumber(String tailNumber) {
        this.tailNumber = tailNumber;
    }

    @Override
    public String toString() {
        return "OneDeadline{" +
                "id=" + id +
                ", tailNumber='" + tailNumber + '\'' +
                ", deadline=" + deadline +
                ", description='" + description + '\'' +
                '}';
    }
}
