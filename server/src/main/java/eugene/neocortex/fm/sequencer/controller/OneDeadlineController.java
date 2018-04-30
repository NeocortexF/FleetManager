package eugene.neocortex.fm.sequencer.controller;

import eugene.neocortex.fm.sequencer.OneDeadlineRepository;
import eugene.neocortex.fm.sequencer.model.OneDeadline;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
public class OneDeadlineController {
    private OneDeadlineRepository repository;

    public OneDeadlineController(OneDeadlineRepository repository) {
        this.repository = repository;
    }

    @GetMapping("dl/all")
    public Collection<OneDeadline> getAllDls() {
        return repository.findAll();
    }


    @RequestMapping(value = "dl/byId/{id}")
    @ResponseBody
    public OneDeadline findDeadlineById(@PathVariable("id") long id) {
        return repository.findOne(id);
    }


    @RequestMapping(value = "dl/byAC/{tailNumber}")
    @ResponseBody
    public List<OneDeadline> findAllDeadlinesByAircraftTailNumber(
            @PathVariable("tailNumber") String tailNumber) {

        return repository.findByTailNumber(tailNumber);
    }


    @RequestMapping(value = "dl/update/{id}/{tailNumber}/{deadline}/{description}")
    @ResponseBody
    public OneDeadline updateDeadlineById(@PathVariable("id") long id,
                                          @PathVariable("tailNumber") String tailNumber,
                                          @PathVariable("deadline") @DateTimeFormat(pattern = "dd-MM-yyyy") Date deadline,
                                          @PathVariable("description") String description) {

        OneDeadline deadlineToUpdate = repository.getOne(id);
        deadlineToUpdate.setTailNumber(tailNumber);
        deadlineToUpdate.setDeadline(deadline);
        deadlineToUpdate.setDescription(description);
        repository.save(deadlineToUpdate);

        return repository.findOne(id);
    }


    @RequestMapping(value = "dl/delete/{id}")
    @ResponseBody
    public boolean removeDeadline(@PathVariable("id") long id) {
        if (repository.exists(id)) {
            repository.delete(id);
            return true;
        } else {
            return false;
        }
    }


    @RequestMapping(value = "dl/add/{tailNumber}/{deadline}/{description}")
    @ResponseBody
    public Boolean addDeadline(@PathVariable("tailNumber") String tailNumber,
                               @PathVariable("deadline") @DateTimeFormat(pattern = "dd-MM-yyyy") Date deadline,
                               @PathVariable("description") String description) {

        if (tailNumber != null && !tailNumber.isEmpty()) {
            OneDeadline deadlineToSave = new OneDeadline();
            deadlineToSave.setTailNumber(tailNumber);
            deadlineToSave.setDeadline(deadline);
            deadlineToSave.setDescription(description);
            repository.save(deadlineToSave);
            return true;
        } else {
            return false;
        }
    }
}
