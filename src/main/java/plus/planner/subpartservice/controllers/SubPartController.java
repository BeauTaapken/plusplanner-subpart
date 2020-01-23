package plus.planner.subpartservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import plus.planner.subpartservice.model.SubPart;
import plus.planner.subpartservice.repository.SubPartRepository;

import java.io.IOException;
import java.util.List;

@RequestMapping("subpart")
@RestController
public class SubPartController {
    private final Logger logger = LoggerFactory.getLogger(SubPartController.class);
    private final SubPartRepository repo;
    private final ObjectMapper objectMapper;

    @Autowired
    public SubPartController(SubPartRepository repo, ObjectMapper objectMapper) {
        this.repo = repo;
        this.objectMapper = objectMapper;
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public void createSubPart(@RequestBody String sbprt) throws IOException {
        final SubPart subPart = objectMapper.readValue(sbprt, SubPart.class);
        logger.info("saving subpart: " + subPart.getSubpartid());
        repo.save(subPart);
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
    public void updateSubPart(@RequestBody String sbprt) throws IOException {
        final SubPart subPart = objectMapper.readValue(sbprt, SubPart.class);
        logger.info("updating subpart: " + subPart.getSubpartid());
        repo.save(subPart);
        logger.info("updated subpart");
    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public void deleteSubPart(@RequestBody String subpartid) {
        logger.info("deleting subpart: " + subpartid);
        repo.deleteById(subpartid);
        logger.info("deleted subpart");
    }
}
