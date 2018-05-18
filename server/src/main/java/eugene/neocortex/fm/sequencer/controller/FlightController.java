package eugene.neocortex.fm.sequencer.controller;

import eugene.neocortex.fm.sequencer.FlightRepository;
import eugene.neocortex.fm.sequencer.model.Flight;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class FlightController {
    private FlightRepository repository;

    public FlightController(FlightRepository repository) {
        this.repository = repository;
    }

    @GetMapping("flight/all")
    public Collection<Flight> getAllFlights() {
        return repository.findAll();
    }


    @RequestMapping(value = "flight/byId/{id}")
    @ResponseBody
    public Flight findFlightById(@PathVariable("id") long id) {
        return repository.findOne(id);
    }


    @PostMapping(value = "flight/save")
    public ResponseEntity createFlight(@RequestBody Flight flight) {
        repository.save(flight);
        return new ResponseEntity(flight, HttpStatus.OK);
    }

    @RequestMapping(value = "flight/delete/{id}")
    @ResponseBody
    public boolean removeFlight(@PathVariable("id") long id) {
        if (repository.exists(id)) {
            repository.delete(id);
            return true;
        } else {
            return false;
        }
    }
}
