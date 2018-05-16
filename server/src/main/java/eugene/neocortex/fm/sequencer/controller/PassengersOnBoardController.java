package eugene.neocortex.fm.sequencer.controller;

import eugene.neocortex.fm.sequencer.PassengersOnBoardRepository;
import eugene.neocortex.fm.sequencer.model.PassengersOnBoard;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class PassengersOnBoardController {
    private PassengersOnBoardRepository repository;

    public PassengersOnBoardController(PassengersOnBoardRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "passenger/byFlightId/{flightId}")
    @ResponseBody
    public Collection<PassengersOnBoard> findAllPassengersOnBoardByFlightId(
            @PathVariable("flightId") Long id) {
        return repository.findAllByFlightId(id);
    }

    @RequestMapping(value = "passenger/add/{flightId}/{name}/{place}")
    @ResponseBody
    public Boolean addPassengerToFlight(@PathVariable("flightId") Long flightId,
                                           @PathVariable("name") String name,
                                           @PathVariable("place") String place) {

        if (flightId != null) {
            PassengersOnBoard passengersOnBoardToAdd = new PassengersOnBoard();
            passengersOnBoardToAdd.setFlightId(flightId);
            passengersOnBoardToAdd.setName(name);
            passengersOnBoardToAdd.setPlace(place);
            repository.save(passengersOnBoardToAdd);
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping(value = "passenger/update/{id}/{flightId}/{name}/{place}")
    @ResponseBody
    public PassengersOnBoard updatePassengerOnBoardById(@PathVariable("id") long id,
                                               @PathVariable("flightId") Long flightId,
                                               @PathVariable("name") String name,
                                               @PathVariable("place") String place) {

        PassengersOnBoard cargoOnBoardToUpdate = repository.getOne(id);
        cargoOnBoardToUpdate.setFlightId(flightId);
        cargoOnBoardToUpdate.setName(name);
        cargoOnBoardToUpdate.setPlace(place);
        repository.save(cargoOnBoardToUpdate);

        return repository.findOne(id);
    }

    @RequestMapping(value = "passenger/delete/{id}")
    @ResponseBody
    public boolean removePassengerOnBoardById(@PathVariable("id") long id) {
        if (repository.exists(id)) {
            repository.delete(id);
            return true;
        } else {
            return false;
        }
    }
}
