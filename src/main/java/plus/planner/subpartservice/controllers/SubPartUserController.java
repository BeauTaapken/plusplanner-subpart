package plus.planner.subpartservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import plus.planner.subpartservice.model.SubPartUser;
import plus.planner.subpartservice.repository.SubPartUserRepository;

import java.io.IOException;

@RequestMapping("subpartuser")
@RestController
public class SubPartUserController {
    @Autowired
    private SubPartUserRepository repo;
    private ObjectMapper mapper;

    SubPartUserController(){
        mapper = new ObjectMapper();
    }

    @RequestMapping(path = "/add/{subpartuser}")
    public void addUserToSubPart(@PathVariable String subpartuser) throws IOException {
        repo.save(mapper.readValue(subpartuser, SubPartUser.class));
    }

    @RequestMapping(path = "/delete/{subpartid}")
    public void removeUserFromSubPart(@PathVariable Long subpartid){
        repo.deleteById(subpartid);
    }
}
