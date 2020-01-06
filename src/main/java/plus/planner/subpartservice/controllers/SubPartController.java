package plus.planner.subpartservice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import plus.planner.subpartservice.model.SubPart;
import plus.planner.subpartservice.repository.SubPartRepository;

import java.util.List;

@RequestMapping("subpart")
@RestController
public class SubPartController {
    private final Logger logger = LoggerFactory.getLogger(SubPartController.class);
    private final SubPartRepository repo;

    @Autowired
    public SubPartController(SubPartRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public void createSubPart(@RequestBody SubPart subpart) {
        logger.info("saving subpart: " + subpart.getSubpartid());
        repo.save(subpart);
        logger.info("saved subpart");
    }

    @RequestMapping(path = "/read/{partid}", method = RequestMethod.GET)
    public List<SubPart> readSubPart(@PathVariable String partid) {
        logger.info("getting subparts for partid: "+ partid);
        final List<SubPart> subParts = repo.findByPartId(partid);
        logger.info("returning subparts");
        return subParts;
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public void updateSubPart(@RequestBody SubPart subpart) {
        logger.info("updating subpart: " + subpart.getSubpartid());
        repo.save(subpart);
        logger.info("updated subpart");
    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public void deleteSubPart(@RequestBody String subpartid) {
        logger.info("deleting subpart: " + subpartid);
        repo.deleteById(subpartid);
        logger.info("deleted subpart");
    }
}
