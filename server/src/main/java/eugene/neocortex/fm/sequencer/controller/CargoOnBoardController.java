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

    @RequestMapping(value = "cargo/byFlightId/{flightId}")
    @ResponseBody
    public Collection<CargoOnBoard> findAllCargoOnBoardByFlightId(
            @PathVariable("flightId") Long id) {
        return repository.findAllByFlightId(id);
    }

    @RequestMapping(value = "cargo/add/{flightId}/{cargoCompartment}/{description}/{weight}")
    @ResponseBody
    public Boolean addCargoOnBoardToFlight(@PathVariable("flightId") Long flightId,
                                           @PathVariable("cargoCompartment") String cargoCompartment,
                                           @PathVariable("description") String description,
                                           @PathVariable("weight") Float weight) {

        if (flightId != null) {
            CargoOnBoard cargoOnBoardToAdd = new CargoOnBoard();
            cargoOnBoardToAdd.setFlightId(flightId);
            cargoOnBoardToAdd.setCargoCompartment(cargoCompartment);
            cargoOnBoardToAdd.setDescription(description);
            cargoOnBoardToAdd.setWeight(weight);
            repository.save(cargoOnBoardToAdd);
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping(value = "cargo/update/{id}/{flightId}/{cargoCompartment}/{description}/{weight}")
    @ResponseBody
    public CargoOnBoard updateCargoOnBoardById(@PathVariable("id") long id,
                                               @PathVariable("flightId") Long flightId,
                                               @PathVariable("cargoCompartment") String cargoCompartment,
                                               @PathVariable("description") String description,
                                               @PathVariable("weight") Float weight) {

        CargoOnBoard cargoOnBoardToUpdate = repository.getOne(id);
        cargoOnBoardToUpdate.setFlightId(flightId);
        cargoOnBoardToUpdate.setCargoCompartment(cargoCompartment);
        cargoOnBoardToUpdate.setDescription(description);
        cargoOnBoardToUpdate.setWeight(weight);
        repository.save(cargoOnBoardToUpdate);

        return repository.findOne(id);
    }

    @RequestMapping(value = "cargo/delete/{id}")
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
