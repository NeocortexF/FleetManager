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


    @RequestMapping(value = "airports/update/{id}/{name}/{codeICAO}")
    @ResponseBody
    public Airports updateAirportById(@PathVariable("id") long id,
                                      @PathVariable("name") String name,
                                      @PathVariable("codeICAO") String codeICAO) {

        Airports airportToUpdate = repository.getOne(id);
        airportToUpdate.setName(name);
        airportToUpdate.setCodeICAO(codeICAO);
        repository.save(airportToUpdate);

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


    @RequestMapping(value = "airports/add/{name}/{codeICAO}")
    @ResponseBody
    public Boolean addAirport(@PathVariable("name") String name,
                              @PathVariable("codeICAO") String codeICAO) {

        Airports airportToSave = new Airports();
        airportToSave.setName(name);
        airportToSave.setCodeICAO(codeICAO);
        repository.save(airportToSave);

        return true;
    }
}
