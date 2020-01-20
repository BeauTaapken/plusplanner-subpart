package plus.planner.subpartservice;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import plus.planner.subpartservice.model.Permission;
import plus.planner.subpartservice.model.State;
import plus.planner.subpartservice.model.SubPart;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@TestPropertySource(locations="classpath:application-test.properties")
@SpringBootTest
public class PlusplannerapiApplicationTests {

    private final Gson gson = new Gson();

    private MockMvc mockMvc;

    private final SubPart subPart = new SubPart("1", "1", "test", "testdes", State.DONE, "2020-10-10");

    private final Permission permission = new Permission("1", "1");

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        mockMvc.perform(MockMvcRequestBuilders.post("/subpart/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(subPart))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));
    }

    @Test
    public void createSubPartCorrectly() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/subpart/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(gson.toJson(subPart))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().is(200));
    }

    @Test
    public void readSubPartCorrectly() throws Exception {
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.get("/subpart/read/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));

        MvcResult result = action.andReturn();

        String expected = "[{\"subpartid\":\"1\",\"partid\":\"1\",\"subpartname\":\"test\",\"description\":\"testdes\",\"state\":\"DONE\",\"enddate\":\"2020-10-10\"}]";

        Assert.assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    public void updateSubPartCorrectly() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/subpart/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(subPart))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));
    }

    @Test
    public void deleteSubPartCorrectly() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/subpart/delete")
                .contentType(MediaType.APPLICATION_JSON)
                .content("1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));
    }

}
