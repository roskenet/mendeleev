package de.roskenet.copper.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.UnsupportedEncodingException;

import static org.assertj.core.api.Assertions.assertThat;

public class GreetingSteps extends CucumberBase {

    @Given("^the client calls our service with the name (.+)$")
    public void the_client_calls_greeting_with_name(String name) throws Exception {
        executeGet("/hello/" + name);
    }

    @Then("^the response code is (\\d+)$")
    public void the_response_code_is(int expectedStatus) {
        assertThat(latestResult.getResponse().getStatus()).isEqualTo(expectedStatus);
    }

    @Then("^the response should contain (.+)$")
    public void the_response_should_contain(String expectedContent) throws UnsupportedEncodingException {
        assertThat(latestResult.getResponse().getContentAsString().contains(expectedContent));
    }
}
