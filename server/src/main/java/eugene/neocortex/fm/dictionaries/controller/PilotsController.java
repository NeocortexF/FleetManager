package eugene.neocortex.fm.dictionaries.controller;


import eugene.neocortex.fm.dictionaries.PilotsRepository;
import eugene.neocortex.fm.dictionaries.model.Pilots;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class PilotsController {
    private PilotsRepository repository;

    public PilotsController(PilotsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("pilots/all")
    public Collection<Pilots> getAllPilots() {
        return repository.findAll();
    }


    @RequestMapping(value = "pilots/byId/{id}")
    @ResponseBody
    public Pilots findPilotById(@PathVariable("id") long id) {
        return repository.findOne(id);
    }


    @RequestMapping(value = "pilots/byName/{name}")
    @ResponseBody
    public Pilots findPilotByName(@PathVariable("name") String name) {
        return repository.findByName(name);
    }


    @RequestMapping(value = "pilots/allBySquad/{squad}")
    @ResponseBody
    public Collection<Pilots> findPilotBySquadron(@PathVariable("squad") Byte squad) {
        return repository.findAllBySquadron(squad);
    }

    @RequestMapping(value = "pilots/update/{id}/{name}/{position}/{squadron}")
    @ResponseBody
    public Pilots updatePilotById(@PathVariable("id") long id,
                                    @PathVariable("name") String name,
                                    @PathVariable("position") String position,
                                    @PathVariable("squadron") Byte squadron) {

        Pilots pilotToUpdate = repository.getOne(id);
        pilotToUpdate.setName(name);
        pilotToUpdate.setPostion(position);
        pilotToUpdate.setSquadron(squadron);
        repository.save(pilotToUpdate);

        return repository.findOne(id);
    }


    @RequestMapping(value = "pilots/delete/{id}")
    @ResponseBody
    public boolean removePilot(@PathVariable("id") long id) {
        if (repository.exists(id)) {
            repository.delete(id);
            return true;
        } else {
            return false;
        }
    }


    @RequestMapping(value = "pilots/add/{name}/{position}/{squadron}")
    @ResponseBody
    public Boolean addPilot(@PathVariable("name") String name,
                               @PathVariable("position") String position,
                               @PathVariable("squadron") Byte squadron) {

            Pilots pilotToAdd = new Pilots();
            pilotToAdd.setName(name);
            pilotToAdd.setPostion(position);
            pilotToAdd.setSquadron(squadron);
            repository.save(pilotToAdd);
            return true;
    }
}
