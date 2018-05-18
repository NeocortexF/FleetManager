package eugene.neocortex.fm.sequencer.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * В секвенсоре основной сущностью является полет
 * Каждый полет это отдельная запись в таблице которая содержит следующее как минимум
 * Выборка делается по датам и группируется по бортам, внутри группировки сортируется по дате
 * Дата для взлета/посадки формата дата+время
 */

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String tailNumber; //TODO: связка со словарем

    private String departureAirport; //TODO: связка со словарем

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")  //TODO: UTC time
    private Date departureTime;

    private String arrivalAirport; //TODO: связка со словарем

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date arrivalTime;

    private String captain;  //TODO: должен быть айди капитана и дергаться из справочника

    private String firstOfficer; //TODO: должен быть айди ВП и дергаться из справочника

    private String flightNumber;


    //тоже самое должен быть метод, а не в моделе
    // дернет по АйДи полета findAllCrewByFlightId
    //private ArrayList<String> cabinCrewOnBoard;
    //private ArrayList<String> passengersOnBoard;

    // Это не должно быть в моделе полета! Это должен быть метод который дернет findAllByAC

    //private ArrayList<Checks> allChecksForThisAircraft;  checks/byAC/VP-BEL
    //private ArrayList<Deadline> allDeadlinesForThisAircraft; dl/byAC/{tailNumber}

    public Flight() {
    }

    public Flight(String tailNumber, String departureAirport, Date departureTime,
                  String arrivalAirport, Date arrivalTime, String captain,
                  String firstOfficer, String flightNumber) {
        this.tailNumber = tailNumber;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.arrivalAirport = arrivalAirport;
        this.arrivalTime = arrivalTime;
        this.captain = captain;
        this.firstOfficer = firstOfficer;
        this.flightNumber = flightNumber;
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

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public String getFirstOfficer() {
        return firstOfficer;
    }

    public void setFirstOfficer(String firstOfficer) {
        this.firstOfficer = firstOfficer;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", tailNumber='" + tailNumber + '\'' +
                ", departureAirport='" + departureAirport + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", captain='" + captain + '\'' +
                ", firstOfficer='" + firstOfficer + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                '}';
    }
}

