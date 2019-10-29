package plus.planner.subpartservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import plus.planner.subpartservice.model.SubPartUser;
import plus.planner.subpartservice.repository.SubPartUserRepository;

import java.io.IOException;

@RequestMapping("SubPartUser")
@RestController
public class SubPartUserController {
    @Autowired
    SubPartUserRepository repo;
    ObjectMapper mapper;

    SubPartUserController(){
        mapper = new ObjectMapper();
    }

    @RequestMapping(path = "/add/{subpartuser}", method = RequestMethod.POST)
    public void addUserToSubPart(@PathVariable String subpartuser) throws IOException {
        repo.save(mapper.readValue(subpartuser, SubPartUser.class));
    }

    @RequestMapping(path = "/delete/{subpartid}", method = RequestMethod.POST)
    public void removeUserFromSubPart(@PathVariable Long subpartid){
        repo.deleteById(subpartid);
    }
}
