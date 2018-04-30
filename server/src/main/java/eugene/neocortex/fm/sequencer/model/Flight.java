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

    private ArrayList<String> passengers;

    private String remarks;

    private ArrayList<Checks> allChecksAndDeadlinesForThisAircraft;

    public Flight() {
    }

    public Flight(String tailNumber, Date departure, Date arrival, ArrayList<String> pilots,
                  ArrayList<String> cabinCrew, ArrayList<String> passengers,
                  String remarks, ArrayList<Checks> allChecksAndDeadlinesForThisAircraft) {
        this.tailNumber = tailNumber;
        this.departure = departure;
        this.arrival = arrival;
        this.pilots = pilots;
        this.cabinCrew = cabinCrew;
        this.passengers = passengers;
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

    public ArrayList<String> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<String> passengers) {
        this.passengers = passengers;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public ArrayList<Checks> getAllChecksAndDeadlinesForThisAircraft() {
        return allChecksAndDeadlinesForThisAircraft;
    }

    public void setAllChecksAndDeadlinesForThisAircraft(ArrayList<Checks> allChecksAndDeadlinesForThisAircraft) {
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
                ", passengers=" + passengers +
                ", remarks='" + remarks + '\'' +
                ", allChecksAndDeadlinesForThisAircraft=" + allChecksAndDeadlinesForThisAircraft +
                '}';
    }
}

