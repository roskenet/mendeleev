package de.roskenet.copper.steps;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
@CucumberContextConfiguration
public class CucumberBase {

    @Autowired
    private MockMvc mockMvc;

    protected MvcResult latestResult;

    public void executeGet(String url) throws Exception {
        latestResult = mockMvc.perform(get(url)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

}
