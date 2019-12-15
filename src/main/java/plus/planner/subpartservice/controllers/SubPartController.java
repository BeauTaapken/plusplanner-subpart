package plus.planner.subpartservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import plus.planner.subpartservice.model.SubPart;
import plus.planner.subpartservice.repository.SubPartRepository;

import java.io.IOException;
import java.util.List;

@RequestMapping("subpart")
@RestController
public class SubPartController {
    @Autowired
    private SubPartRepository repo;
    private ObjectMapper mapper;

    SubPartController(){
        mapper = new ObjectMapper();
    }

    @RequestMapping(path = "/create")
    public void createSubPart(@RequestBody String subpart) {
        try {
            repo.save(mapper.readValue(subpart, SubPart.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(path = "/read/{partid}")
    public List<SubPart> readSubPart(@PathVariable String partid){
        List<SubPart> subParts = repo.findByPartId(partid);
        return subParts;
    }

    @RequestMapping(path = "/update")
    public void updateSubPart(@RequestBody String subpart) {
        try {
            repo.save(mapper.readValue(subpart, SubPart.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(path = "/delete/{subpartid}")
    public void deleteSubPart(@PathVariable String subpartid){
        repo.deleteById(subpartid);
    }
}
