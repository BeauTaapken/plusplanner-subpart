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

@CrossOrigin
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

    @PostMapping(path = "/create")
    public void createSubPart(@RequestBody String sbprt) throws IOException {
        final SubPart subPart = objectMapper.readValue(sbprt, SubPart.class);
        logger.info("saving subpart: {}", subPart.getSubpartid());
        repo.save(subPart);
        logger.info("saved subpart");
    }

    @GetMapping(path = "/read/{partid}")
    public List<SubPart> readSubPart(@PathVariable String partid) {
        logger.info("getting subparts for partid: {}", partid);
        final List<SubPart> subParts = repo.findByPartId(partid);
        logger.info("returning subparts");
        return subParts;
    }

    @PostMapping(path = "/update")
    public void updateSubPart(@RequestBody String sbprt) throws IOException {
        final SubPart subPart = objectMapper.readValue(sbprt, SubPart.class);
        logger.info("updating subpart: {}", subPart.getSubpartid());
        repo.save(subPart);
        logger.info("updated subpart");
    }

    @PostMapping(path = "/delete")
    public void deleteSubPart(@RequestBody String subpartid) {
        logger.info("deleting subpart: {}", subpartid);
        repo.deleteById(subpartid);
        logger.info("deleted subpart");
    }
}
