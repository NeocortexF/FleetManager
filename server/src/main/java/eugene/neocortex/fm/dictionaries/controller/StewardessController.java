package eugene.neocortex.fm.dictionaries.controller;

import eugene.neocortex.fm.dictionaries.StewardessRepository;
import eugene.neocortex.fm.dictionaries.model.Stewardess;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class StewardessController {
    private StewardessRepository repository;

    public StewardessController(StewardessRepository repository) {
        this.repository = repository;
    }

    @GetMapping("stewardess/all")
    public Collection<Stewardess> getAllStewardess() {
        return repository.findAll();
    }


    @RequestMapping(value = "stewardess/byId/{id}")
    @ResponseBody
    public Stewardess findStewardessById(@PathVariable("id") long id) {
        return repository.findOne(id);
    }


    @RequestMapping(value = "stewardess/byName/{name}")
    @ResponseBody
    public Stewardess findStewardessByName(@PathVariable("name") String name) {
        return repository.findByName(name);
    }


    @RequestMapping(value = "stewardess/allByBrigade/{brigade}")
    @ResponseBody
    public Collection<Stewardess> findStewardessByBrigade(@PathVariable("brigade") Byte brigade) {
        return repository.findAllByBrigade(brigade);
    }

    @RequestMapping(value = "stewardess/update/{id}/{name}/{position}/{brigade}")
    @ResponseBody
    public Stewardess updateStewardessById(@PathVariable("id") long id,
                                           @PathVariable("name") String name,
                                           @PathVariable("position") String position,
                                           @PathVariable("brigade") Byte brigade) {

        Stewardess stewardessToUpdate = repository.getOne(id);
        stewardessToUpdate.setName(name);
        stewardessToUpdate.setPosition(position);
        stewardessToUpdate.setBrigade(brigade);
        repository.save(stewardessToUpdate);

        return repository.findOne(id);
    }


    @RequestMapping(value = "stewardess/delete/{id}")
    @ResponseBody
    public boolean removeStewardess(@PathVariable("id") long id) {
        if (repository.exists(id)) {
            repository.delete(id);
            return true;
        } else {
            return false;
        }
    }


    @RequestMapping(value = "stewardess/add/{name}/{position}/{brigade}")
    @ResponseBody
    public Boolean addStewardess(@PathVariable("name") String name,
                                 @PathVariable("position") String position,
                                 @PathVariable("brigade") Byte brigade) {

        Stewardess stewardessToAdd = new Stewardess();
        stewardessToAdd.setName(name);
        stewardessToAdd.setPosition(position);
        stewardessToAdd.setBrigade(brigade);
        repository.save(stewardessToAdd);
        return true;
    }
}
