package eugene.neocortex.fm.dictionaries.controller;

import eugene.neocortex.fm.dictionaries.AirportsRepository;
import eugene.neocortex.fm.dictionaries.model.Airports;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class AirportsController {
    private AirportsRepository repository;

    public AirportsController(AirportsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("airports/all")
    public Collection<Airports> getAllAirports() {
        return repository.findAll();
    }


    @RequestMapping(value = "airports/byId/{id}")
    @ResponseBody
    public Airports findAirportById(@PathVariable("id") long id) {
        return repository.findOne(id);
    }


    @RequestMapping(value = "airports/byName/{name}")
    @ResponseBody
    public Airports findAirportByName(@PathVariable("name") String name) {
        return repository.findByName(name);
    }


    @RequestMapping(value = "airports/byCode/{codeICAO}")
    @ResponseBody
    public Airports findAirportByCodeICAO(@PathVariable("codeICAO") String codeICAO) {
        return repository.findByCodeICAO(codeICAO);
    }


    @RequestMapping(value = "airports/update/{id}/{tailNumber}/{modification}/{engineType}/{msn}")
    @ResponseBody
    public Airports updateAirportById(@PathVariable("id") long id,
                                      @PathVariable("tailNumber") String tailNumber,
                                      @PathVariable("modification") String modification,
                                      @PathVariable("engineType") String engineType,
                                      @PathVariable("msn") Integer msn) {

        Airports aircraftToUpdate = repository.getOne(id);
        aircraftToUpdate.setTailNumber(tailNumber);
        aircraftToUpdate.setModification(modification);
        aircraftToUpdate.setEngineType(engineType);
        aircraftToUpdate.setMsn(msn);
        repository.save(aircraftToUpdate);

        return repository.findOne(id);
    }


    @RequestMapping(value = "airports/delete/{id}")
    @ResponseBody
    public boolean removeAirport(@PathVariable("id") long id) {
        if (repository.exists(id)) {
            repository.delete(id);
            return true;
        } else {
            return false;
        }
    }


    @RequestMapping(value = "fleet/add/{tailNumber}/{modification}/{engineType}/{msn}")
    @ResponseBody
    public Boolean addAirport(@PathVariable("tailNumber") String tailNumber,
                              @PathVariable("modification") String modification,
                              @PathVariable("engineType") String engineType,
                              @PathVariable("msn") Integer msn) {

        if (tailNumber != null && !tailNumber.isEmpty()) {
            Airports aircraftToSave = new Airports();
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
