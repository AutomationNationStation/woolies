package StepDefinitions;

import Requests.ApiRequests;
import cucumber.api.java.en.Then;

public class ThenSteps {

    @Then("^I should see which days will be above 20 degrees and sunny$")
    public void outputWeatherUpdate() {
        ApiRequests.outputWeatherUpdate();
    }
}
