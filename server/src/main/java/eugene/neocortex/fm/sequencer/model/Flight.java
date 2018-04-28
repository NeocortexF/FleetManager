package eugene.neocortex.fm.sequencer.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;

/**
 * В секвенесере основной сущностью является полет
 * Каждый полет это отдельная запись в таблице которая содержит следующе как минимимум
 * Выборка делается по датам и групируется по бортам, внутри группировке соритруется по дате
 * Дата формата дата+время
 */

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String tailNumber;

    private Date departure;

    private Date arrival;

    private ArrayList<String> pilots;

    private ArrayList<String> cabinCrew;

    private ArrayList<String> passangers;

    private String remarks;

    private ArrayList<Deadlines> allChecksAndDeadlinesForThisAircraft;

    public Flight() {
    }

    public Flight(String tailNumber, Date departure, Date arrival, ArrayList<String> pilots,
                  ArrayList<String> cabinCrew, ArrayList<String> passangers,
                  String remarks, ArrayList<Deadlines> allChecksAndDeadlinesForThisAircraft) {
        this.tailNumber = tailNumber;
        this.departure = departure;
        this.arrival = arrival;
        this.pilots = pilots;
        this.cabinCrew = cabinCrew;
        this.passangers = passangers;
        this.remarks = remarks;
        this.allChecksAndDeadlinesForThisAircraft = allChecksAndDeadlinesForThisAircraft;
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

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public ArrayList<String> getPilots() {
        return pilots;
    }

    public void setPilots(ArrayList<String> pilots) {
        this.pilots = pilots;
    }

    public ArrayList<String> getCabinCrew() {
        return cabinCrew;
    }

    public void setCabinCrew(ArrayList<String> cabinCrew) {
        this.cabinCrew = cabinCrew;
    }

    public ArrayList<String> getPassangers() {
        return passangers;
    }

    public void setPassangers(ArrayList<String> passangers) {
        this.passangers = passangers;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public ArrayList<Deadlines> getAllChecksAndDeadlinesForThisAircraft() {
        return allChecksAndDeadlinesForThisAircraft;
    }

    public void setAllChecksAndDeadlinesForThisAircraft(ArrayList<Deadlines> allChecksAndDeadlinesForThisAircraft) {
        this.allChecksAndDeadlinesForThisAircraft = allChecksAndDeadlinesForThisAircraft;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", tailNumber='" + tailNumber + '\'' +
                ", departure=" + departure +
                ", arrival=" + arrival +
                ", pilots=" + pilots +
                ", cabinCrew=" + cabinCrew +
                ", passangers=" + passangers +
                ", remarks='" + remarks + '\'' +
                ", allChecksAndDeadlinesForThisAircraft=" + allChecksAndDeadlinesForThisAircraft +
                '}';
    }
}

