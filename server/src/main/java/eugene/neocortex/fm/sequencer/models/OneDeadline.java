package eugene.neocortex.fm.sequencer.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Модель данных для одного дедлайна,
 * что бы передавать объект в спискок дедлайнов
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OneDeadline {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private Date deadline;

    private String description;

    public OneDeadline() {
    }

    public OneDeadline(Date deadline, String description) {
        this.deadline = deadline;
        this.description = description;
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

    @Override
    public String toString() {
        return "OneDeadline{" +
                "id=" + id +
                ", deadline=" + deadline +
                ", description='" + description + '\'' +
                '}';
    }
}
