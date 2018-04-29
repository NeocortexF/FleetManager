package eugene.neocortex.fm.sequencer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * Модель списка дедлайнов для борта,
 * а так же его крайние чеки
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Deadlines {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    //ключ - айди борта по которому дедлайн
    private long key;

    private String tailNumber;

    //@OneToMany(mappedBy = "Deadlines")
    private ArrayList<OneDeadline> deadlineList;

    private Date latestCcheckDate;

    private int latestCcheckFlightHours;

    private int latestCcheckFlightCycles;

    private Date latestAcheckDate;

    private int lastestAcheckFlightHours;

    private int lastetAcheckFlightCycles;

    private Date latestWeeklyCheckDate;

    private int lastestWeeklyCheckFlightHours;

    private int latestWeeklyCheckFlightCycles;

    public Deadlines() {
    }

    public Deadlines(long key, String tailNumber, ArrayList<OneDeadline> deadlineList,
                     Date latestCcheckDate, int latestCcheckFlightHours, int latestCcheckFlightCycles,
                     Date latestAcheckDate, int lastestAcheckFlightHours, int lastetAcheckFlightCycles,
                     Date latestWeeklyCheckDate, int lastestWeeklyCheckFlightHours, int latestWeeklyCheckFlightCycles) {
        this.key = key;
        this.tailNumber = tailNumber;
        this.deadlineList = deadlineList;
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

    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }

    public String getTailNumber() {
        return tailNumber;
    }

    public void setTailNumber(String tailNumber) {
        this.tailNumber = tailNumber;
    }

    public ArrayList<OneDeadline> getDeadlineList() {
        return deadlineList;
    }

    public void setDeadlineList(ArrayList<OneDeadline> deadlineList) {
        this.deadlineList = deadlineList;
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
        return "Deadlines{" +
                "id=" + id +
                ", key=" + key +
                ", tailNumber='" + tailNumber + '\'' +
                ", deadlineList=" + deadlineList +
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
