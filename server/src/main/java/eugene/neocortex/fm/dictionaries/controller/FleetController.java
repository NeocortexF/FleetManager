package eugene.neocortex.fm.dictionaries.controller;

import eugene.neocortex.fm.dictionaries.FleetRepository;
import eugene.neocortex.fm.dictionaries.model.Fleet;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class FleetController {
    private FleetRepository repository;

    public FleetController(FleetRepository repository) {
        this.repository = repository;
    }


    @GetMapping("fleet/all")
    public Collection<Fleet> getAllFleet() {
        return repository.findAll();
    }


    @RequestMapping(value = "fleet/byId/{id}")
    @ResponseBody
    public Fleet findAircraftById(@PathVariable("id") long id) {
        return repository.findOne(id);
    }


    @RequestMapping(value = "fleet/update/{id}/{tailNumber}/{modification}/{engineType}/{msn}")
    @ResponseBody
    public Fleet updateAircraftById(@PathVariable("id") long id,
                                    @PathVariable("tailNumber") String tailNumber,
                                    @PathVariable("modification") String modification,
                                    @PathVariable("engineType") String engineType,
                                    @PathVariable("msn") Integer msn) {

        Fleet aircraftToUpdate = repository.getOne(id);
        aircraftToUpdate.setTailNumber(tailNumber);
        aircraftToUpdate.setModification(modification);
        aircraftToUpdate.setEngineType(engineType);
        aircraftToUpdate.setMsn(msn);
        repository.save(aircraftToUpdate);

        return repository.findOne(id);
    }


    @RequestMapping(value = "fleet/delete/{id}")
    @ResponseBody
    public boolean removeAircraft(@PathVariable("id") long id) {
        if (repository.exists(id)) {
            repository.delete(id);
            return true;
        } else {
            return false;
        }
    }


    @RequestMapping(value = "fleet/add/{tailNumber}/{modification}/{engineType}/{msn}")
    @ResponseBody
    public Boolean addAircraft(@PathVariable("tailNumber") String tailNumber,
                               @PathVariable("modification") String modification,
                               @PathVariable("engineType") String engineType,
                               @PathVariable("msn") Integer msn) {

        if (tailNumber != null && !tailNumber.isEmpty()) {
            Fleet aircraftToSave = new Fleet();
            aircraftToSave.setTailNumber(tailNumber);
            aircraftToSave.setModification(modification);
            aircraftToSave.setEngineType(engineType);
            aircraftToSave.setMsn(msn);
            repository.save(aircraftToSave);
            return true;
        } else {
            return false;
        }
    }
}
