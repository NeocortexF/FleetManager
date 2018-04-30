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

    private Date latestCcheckDate;

    private int latestCcheckFlightHours;

    private int latestCcheckFlightCycles;

    private Date latestAcheckDate;

    private int lastestAcheckFlightHours;

    private int lastetAcheckFlightCycles;

    private Date latestWeeklyCheckDate;

    private int lastestWeeklyCheckFlightHours;

    private int latestWeeklyCheckFlightCycles;

    public Checks() {
    }

    public Checks(String tailNumber, Date latestCcheckDate, int latestCcheckFlightHours,
                  int latestCcheckFlightCycles, Date latestAcheckDate,
                  int lastestAcheckFlightHours, int lastetAcheckFlightCycles,
                  Date latestWeeklyCheckDate, int lastestWeeklyCheckFlightHours, int latestWeeklyCheckFlightCycles) {
        this.tailNumber = tailNumber;
        this.latestCcheckDate = latestCcheckDate;
        this.latestCcheckFlightHours = latestCcheckFlightHours;
        this.latestCcheckFlightCycles = latestCcheckFlightCycles;
        this.latestAcheckDate = latestAcheckDate;
        this.lastestAcheckFlightHours = lastestAcheckFlightHours;
        this.lastetAcheckFlightCycles = lastetAcheckFlightCycles;
        this.latestWeeklyCheckDate = latestWeeklyCheckDate;
        this.lastestWeeklyCheckFlightHours = lastestWeeklyCheckFlightHours;
        this.latestWeeklyCheckFlightCycles = latestWeeklyCheckFlightCycles;
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

    public Date getLatestCcheckDate() {
        return latestCcheckDate;
    }

    public void setLatestCcheckDate(Date latestCcheckDate) {
        this.latestCcheckDate = latestCcheckDate;
    }

    public int getLatestCcheckFlightHours() {
        return latestCcheckFlightHours;
    }

    public void setLatestCcheckFlightHours(int latestCcheckFlightHours) {
        this.latestCcheckFlightHours = latestCcheckFlightHours;
    }

    public int getLatestCcheckFlightCycles() {
        return latestCcheckFlightCycles;
    }

    public void setLatestCcheckFlightCycles(int latestCcheckFlightCycles) {
        this.latestCcheckFlightCycles = latestCcheckFlightCycles;
    }

    public Date getLatestAcheckDate() {
        return latestAcheckDate;
    }

    public void setLatestAcheckDate(Date latestAcheckDate) {
        this.latestAcheckDate = latestAcheckDate;
    }

    public int getLastestAcheckFlightHours() {
        return lastestAcheckFlightHours;
    }

    public void setLastestAcheckFlightHours(int lastestAcheckFlightHours) {
        this.lastestAcheckFlightHours = lastestAcheckFlightHours;
    }

    public int getLastetAcheckFlightCycles() {
        return lastetAcheckFlightCycles;
    }

    public void setLastetAcheckFlightCycles(int lastetAcheckFlightCycles) {
        this.lastetAcheckFlightCycles = lastetAcheckFlightCycles;
    }

    public Date getLatestWeeklyCheckDate() {
        return latestWeeklyCheckDate;
    }

    public void setLatestWeeklyCheckDate(Date latestWeeklyCheckDate) {
        this.latestWeeklyCheckDate = latestWeeklyCheckDate;
    }

    public int getLastestWeeklyCheckFlightHours() {
        return lastestWeeklyCheckFlightHours;
    }

    public void setLastestWeeklyCheckFlightHours(int lastestWeeklyCheckFlightHours) {
        this.lastestWeeklyCheckFlightHours = lastestWeeklyCheckFlightHours;
    }

    public int getLatestWeeklyCheckFlightCycles() {
        return latestWeeklyCheckFlightCycles;
    }

    public void setLatestWeeklyCheckFlightCycles(int latestWeeklyCheckFlightCycles) {
        this.latestWeeklyCheckFlightCycles = latestWeeklyCheckFlightCycles;
    }

    @Override
    public String toString() {
        return "Checks{" +
                "id=" + id +
                ", tailNumber='" + tailNumber + '\'' +
                ", latestCcheckDate=" + latestCcheckDate +
                ", latestCcheckFlightHours=" + latestCcheckFlightHours +
                ", latestCcheckFlightCycles=" + latestCcheckFlightCycles +
                ", latestAcheckDate=" + latestAcheckDate +
                ", lastestAcheckFlightHours=" + lastestAcheckFlightHours +
                ", lastetAcheckFlightCycles=" + lastetAcheckFlightCycles +
                ", latestWeeklyCheckDate=" + latestWeeklyCheckDate +
                ", lastestWeeklyCheckFlightHours=" + lastestWeeklyCheckFlightHours +
                ", latestWeeklyCheckFlightCycles=" + latestWeeklyCheckFlightCycles +
                '}';
    }
}
