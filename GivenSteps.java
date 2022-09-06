package StepDefinitions;

import Requests.ApiRequests;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;

import java.util.Map;

public class GivenSteps {

    @Given("^I make the below api calls to the weather map$")
    public void makeWeatherApiCalls(DataTable dataTable) {
        ApiRequests apiRequests = new ApiRequests();
        String city = null;
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        for (Map.Entry<String, String> set : data.entrySet()) {
            if (set.getKey().equalsIgnoreCase("city")) {
                city = set.getValue();
            }
        }
        apiRequests.sendRequestAndSetResponse(city);
    }
}
