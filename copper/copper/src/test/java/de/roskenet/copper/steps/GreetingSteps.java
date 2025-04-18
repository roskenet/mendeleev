package de.roskenet.copper.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@CucumberContextConfiguration
public class GreetingSteps {

    @Autowired
    private MockMvc mockMvc;

    private ResponseEntity<String> response;

    @Given("the client calls our service with the name {string}")
    public void the_client_calls_greeting_with_name(String name) throws Exception {
        MvcResult result = mockMvc.perform(get("/hello/{name}", name)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        response = ResponseEntity.ok(result.getResponse().getContentAsString());
    }

    @Then("the response code is {int}")
    public void the_response_code_is(int expectedStatus) {
        assertThat(response.getStatusCodeValue()).isEqualTo(expectedStatus);
    }

    @Then("the response should contain {string}")
    public void the_response_should_contain(String expectedContent) {
        assertThat(response.getBody()).contains(expectedContent);
    }
}
