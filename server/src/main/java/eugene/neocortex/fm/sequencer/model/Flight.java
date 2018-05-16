package eugene.neocortex.fm.sequencer.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;

/**
 * В секвенсоре основной сущностью является полет
 * Каждый полет это отдельная запись в таблице которая содержит следующее как минимум
 * Выборка делается по датам и группируется по бортам, внутри группировки сортируется по дате
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

    private ArrayList<String> pilotsOnBoard;

    private ArrayList<String> cabinCrewOnBoard;

    private ArrayList<String> passengersOnBoard;

    private String remarks;

    private ArrayList<Checks> allChecksForThisAircraft;

    private ArrayList<Deadline> allDeadlinesForThisAircraft;

    public Flight() {
    }

    public Flight(String tailNumber, Date departure, Date arrival, ArrayList<String> pilotsOnBoard,
                  ArrayList<String> cabinCrewOnBoard, ArrayList<String> passengersOnBoard,
                  String remarks, ArrayList<Checks> allChecksForThisAircraft,
                  ArrayList<Deadline> allDeadlinesForThisAircraft) {
        this.tailNumber = tailNumber;
        this.departure = departure;
        this.arrival = arrival;
        this.pilotsOnBoard = pilotsOnBoard;
        this.cabinCrewOnBoard = cabinCrewOnBoard;
        this.passengersOnBoard = passengersOnBoard;
        this.remarks = remarks;
        this.allChecksForThisAircraft = allChecksForThisAircraft;
        this.allDeadlinesForThisAircraft = allDeadlinesForThisAircraft;
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

    public ArrayList<String> getPilotsOnBoard() {
        return pilotsOnBoard;
    }

    public void setPilotsOnBoard(ArrayList<String> pilotsOnBoard) {
        this.pilotsOnBoard = pilotsOnBoard;
    }

    public ArrayList<String> getCabinCrewOnBoard() {
        return cabinCrewOnBoard;
    }

    public void setCabinCrewOnBoard(ArrayList<String> cabinCrewOnBoard) {
        this.cabinCrewOnBoard = cabinCrewOnBoard;
    }

    public ArrayList<String> getPassengersOnBoard() {
        return passengersOnBoard;
    }

    public void setPassengersOnBoard(ArrayList<String> passengersOnBoard) {
        this.passengersOnBoard = passengersOnBoard;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public ArrayList<Checks> getAllChecksForThisAircraft() {
        return allChecksForThisAircraft;
    }

    public void setAllChecksForThisAircraft(ArrayList<Checks> allChecksForThisAircraft) {
        this.allChecksForThisAircraft = allChecksForThisAircraft;
    }

    public ArrayList<Deadline> getAllDeadlinesForThisAircraft() {
        return allDeadlinesForThisAircraft;
    }

    public void setAllDeadlinesForThisAircraft(ArrayList<Deadline> allDeadlinesForThisAircraft) {
        this.allDeadlinesForThisAircraft = allDeadlinesForThisAircraft;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", tailNumber='" + tailNumber + '\'' +
                ", departure=" + departure +
                ", arrival=" + arrival +
                ", pilotsOnBoard=" + pilotsOnBoard +
                ", cabinCrewOnBoard=" + cabinCrewOnBoard +
                ", passengersOnBoard=" + passengersOnBoard +
                ", remarks='" + remarks + '\'' +
                ", allChecksForThisAircraft=" + allChecksForThisAircraft +
                ", allDeadlinesForThisAircraft=" + allDeadlinesForThisAircraft +
                '}';
    }
}

