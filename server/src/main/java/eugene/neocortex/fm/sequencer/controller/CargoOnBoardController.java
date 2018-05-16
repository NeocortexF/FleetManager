package eugene.neocortex.fm.sequencer.controller;

import eugene.neocortex.fm.sequencer.CargoOnBoardRepository;
import eugene.neocortex.fm.sequencer.model.CargoOnBoard;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CargoOnBoardController {
    private CargoOnBoardRepository repository;

    public CargoOnBoardController(CargoOnBoardRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "cabin/byFlightId/{flightId}")
    @ResponseBody
    public Collection<CargoOnBoard> findAllCargoOnBoardByFlightId(
            @PathVariable("flightId") Long id) {
        return repository.findAllByFlightId(id);
    }

    @RequestMapping(value = "cabin/add/{flightId}/{name}/{position}")
    @ResponseBody
    public Boolean addCargoOnBoardToFlight(@PathVariable("flightId") Long flightId,
                                           @PathVariable("name") String name,
                                           @PathVariable("position") String position) {

        if (flightId != null) {
            CargoOnBoard cabinCrewOnBoard = new CargoOnBoard();
            cabinCrewOnBoard.setFlightId(flightId);
            cabinCrewOnBoard.setName(name);
            cabinCrewOnBoard.setPosition(position);
            repository.save(cabinCrewOnBoard);
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping(value = "cabin/update/{id}/{flightId}/{name}/{position}")
    @ResponseBody
    public CargoOnBoard updateCargoOnBoardById(@PathVariable("id") long id,
                                               @PathVariable("flightId") long flightId,
                                               @PathVariable("tailNumber") String name,
                                               @PathVariable("description") String position) {

        CargoOnBoard cabinCrewOnBoardToUpdate = repository.getOne(id);
        cabinCrewOnBoardToUpdate.setFlightId(flightId);
        cabinCrewOnBoardToUpdate.setName(name);
        cabinCrewOnBoardToUpdate.setPosition(position);
        repository.save(cabinCrewOnBoardToUpdate);

        return repository.findOne(id);
    }

    @RequestMapping(value = "cabin/delete/{id}")
    @ResponseBody
    public boolean removeCargoOnBoardById(@PathVariable("id") long id) {
        if (repository.exists(id)) {
            repository.delete(id);
            return true;
        } else {
            return false;
        }
    }
}
