package eugene.neocortex.fm.sequencer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Модель списка краних чеков на борт
 **/

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Checks {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String tailNumber;

    //A-C-Weekly
    private String checkType;

    //дата закрытия чека
    private Date dateOfCheckDone;

    private Date checkDeadline;

    private int checkFlightHours;

    private int checkFlightCycles;

    //Closed, planned
    private String status;


    public Checks() {
    }

    public Checks(String tailNumber, String checkType, Date dateOfCheckDone,
                  Date checkDeadline, int checkFlightHours, int checkFlightCycles,
                  String status) {
        this.tailNumber = tailNumber;
        this.checkType = checkType;
        this.dateOfCheckDone = dateOfCheckDone;
        this.checkDeadline = checkDeadline;
        this.checkFlightHours = checkFlightHours;
        this.checkFlightCycles = checkFlightCycles;
        this.status = status;
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

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public Date getDateOfCheckDone() {
        return dateOfCheckDone;
    }

    public void setDateOfCheckDone(Date dateOfCheckDone) {
        this.dateOfCheckDone = dateOfCheckDone;
    }

    public Date getCheckDeadline() {
        return checkDeadline;
    }

    public void setCheckDeadline(Date checkDeadline) {
        this.checkDeadline = checkDeadline;
    }

    public int getCheckFlightHours() {
        return checkFlightHours;
    }

    public void setCheckFlightHours(int checkFlightHours) {
        this.checkFlightHours = checkFlightHours;
    }

    public int getCheckFlightCycles() {
        return checkFlightCycles;
    }

    public void setCheckFlightCycles(int checkFlightCycles) {
        this.checkFlightCycles = checkFlightCycles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Checks{" +
                "id=" + id +
                ", tailNumber='" + tailNumber + '\'' +
                ", checkType='" + checkType + '\'' +
                ", dateOfCheckDone=" + dateOfCheckDone +
                ", checkDeadline=" + checkDeadline +
                ", checkFlightHours=" + checkFlightHours +
                ", checkFlightCycles=" + checkFlightCycles +
                ", status='" + status + '\'' +
                '}';
    }
}
