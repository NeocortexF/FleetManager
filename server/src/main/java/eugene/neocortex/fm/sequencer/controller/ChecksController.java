package eugene.neocortex.fm.sequencer.controller;


import eugene.neocortex.fm.sequencer.ChecksRepository;
import eugene.neocortex.fm.sequencer.model.Checks;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;

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
    public Collection<Checks> findChecksByTailNumber(@PathVariable("tailNumber") String tailNumber) {
        return repository.findAllByTailNumber(tailNumber);
    }


    @RequestMapping(value = "checks/close/{id}/{dateOfCheckDone}/{status}")
    @ResponseBody
    public Boolean closeCheck(@PathVariable("id") long id,
                              @PathVariable("dateOfCheckDone") @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateOfCheckDone,
                              @PathVariable("status") String status) {
        if (repository.exists(id)) {
            Checks checkToClose = repository.findOne(id);
            checkToClose.setDateOfCheckDone(dateOfCheckDone);
            checkToClose.setStatus(status);
            repository.save(checkToClose);
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping(value = "checks/add/{tailNumber}/{checkType}/" +
            "{checkDeadline}/{checkFlightHours}/{checkFlightCycles}/{status}")
    @ResponseBody
    public Boolean addCheck(@PathVariable("tailNumber") String tailNumber,
                            @PathVariable("checkType") String checkType,
                            @PathVariable("checkDeadline") @DateTimeFormat(pattern = "dd-MM-yyyy") Date checkDeadline,
                            @PathVariable("checkFlightHours") Integer checkFlightHours,
                            @PathVariable("checkFlightCycles") Integer checkFlightCycles,
                            @PathVariable("status") String status) {

        if (tailNumber != null && !tailNumber.isEmpty()) {
            Checks checkToAdd = new Checks();
            checkToAdd.setTailNumber(tailNumber);
            checkToAdd.setCheckType(checkType);
            checkToAdd.setCheckDeadline(checkDeadline);
            checkToAdd.setCheckFlightHours(checkFlightHours);
            checkToAdd.setCheckFlightCycles(checkFlightCycles);
            checkToAdd.setStatus(status);
            repository.save(checkToAdd);
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
