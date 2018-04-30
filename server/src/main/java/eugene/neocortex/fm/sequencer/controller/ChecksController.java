package eugene.neocortex.fm.sequencer.controller;


import eugene.neocortex.fm.sequencer.ChecksRepository;
import eugene.neocortex.fm.sequencer.model.Checks;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
public class ChecksController {
    private ChecksRepository repository;

    public ChecksController(ChecksRepository repository) {
        this.repository = repository;
    }

    @GetMapping("checks/all")
    public Collection<Checks> getAllChecks() {
        return repository.findAll();
    }

    @RequestMapping(value = "checks/byId/{id}")
    @ResponseBody
    public Checks findChecksById(@PathVariable("id") long id) {
        return repository.findOne(id);
    }

    @RequestMapping(value = "checks/byAC/{tailNumber}")
    @ResponseBody
    public Checks findChecksByTailNumber(@PathVariable("tailNumber") String tailNumber) {
        return repository.findByTailNumber(tailNumber);
    }

//    @PostMapping(value = "checks/save")
//    public ResponseEntity createChecks(@RequestBody Checks checks) {
//        repository.save(checks);
//        return new ResponseEntity(checks, HttpStatus.OK);
//    }

    @RequestMapping(value = "checks/add/{tailNumber}/{latestCcheckDate}/{latestCcheckFlightHours/" +
            "{}")
    @ResponseBody
    public Boolean addDeadline(@PathVariable("tailNumber") String tailNumber,
                               @PathVariable("latestCcheckDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date latestCcheckDate,
                               @PathVariable("latestCcheckFlightHours") Integer latestCcheckFlightHours) {

        if (tailNumber != null && !tailNumber.isEmpty()) {
            Checks checksToSave = new Checks();
            deadlineToSave.setTailNumber(tailNumber);

            repository.save(deadlineToSave);
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping(value = "checks/delete/{id}")
    @ResponseBody
    public boolean removeChecksById(@PathVariable("id") long id) {
        if (repository.exists(id)) {
            repository.delete(id);
            return true;
        } else {
            return false;
        }
    }
}
