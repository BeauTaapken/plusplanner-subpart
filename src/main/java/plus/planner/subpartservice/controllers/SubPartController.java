package plus.planner.subpartservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import plus.planner.subpartservice.model.SubPart;
import plus.planner.subpartservice.repository.SubPartRepository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("subpart")
@RestController
public class SubPartController {
    @Autowired
    SubPartRepository repo;
    ObjectMapper mapper;

    SubPartController(){
        mapper = new ObjectMapper();
    }

    @RequestMapping(path = "/create/{subpart}")
    public void createSubPart(@PathVariable String subpart) {
        try {
            repo.save(mapper.readValue(subpart, SubPart.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(path = "/read/{partid}")
    public List<SubPart> readSubPart(@PathVariable Long partid){
        List<SubPart> subParts = repo.findAll();
        return subParts.stream().filter(x -> x.getPartid() == partid).collect(Collectors.toList());
    }

    @RequestMapping(path = "/update/{subpart}")
    public void updateSubPart(@PathVariable String subpart) {
        try {
            repo.save(mapper.readValue(subpart, SubPart.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(path = "/delete/{subpartid}")
    public void deleteSubPart(@PathVariable Long subpartid){
        repo.deleteById(subpartid);
    }
}
