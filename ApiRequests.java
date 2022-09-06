package Requests;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;


public class ApiRequests {

    private String apiKey = "4b8033340a696d79787337a48316e200";
    private static List<String> daysAbove20 = new ArrayList<String>();
    private static List<String> sunnyDays = new ArrayList<String>();

    public void sendRequestAndSetResponse(String city) {
        HttpResponse<JsonNode> response = Unirest.post("https://api.openweathermap.org/data/2.5/forecast?mode=json")
                .queryString("appid", apiKey)
                .queryString("q", city)
                .queryString("units", "metric")
                .asJson();

        parseResponseAndSetData(response);
    }

    private void parseResponseAndSetData(final HttpResponse<JsonNode> response) {
        JSONObject object = response.getBody().getObject();
        int size = Integer.parseInt(object.get("cnt").toString());
        JSONArray array = object.getJSONArray("list");
        for (int i = 0; i < size; i++) {
            String temp = array.getJSONObject(i).getJSONObject("main").get("temp").toString();
            JSONArray weatherArray = array.getJSONObject(i).getJSONArray("weather");
            String weather = weatherArray.getJSONObject(0).get("main").toString();
            String date = array.getJSONObject(i).get("dt_txt").toString();
            if (Double.parseDouble(temp) > 20.0) {
                daysAbove20.add(date.split(" ")[0]);
            }
            if (weather.equalsIgnoreCase("Clear")) {
                sunnyDays.add(date);
            }
        }
    }

    public static void outputWeatherUpdate() {
        Set<String> tempSet = new LinkedHashSet<String>(daysAbove20);
        for (String temp : tempSet) {
            outputDatesAndFrequencyForTemperature(temp);
        }
        for (int i = 0; i < sunnyDays.size(); i++) {
            outputSunnyDaysAndTimes(sunnyDays.get(i));
        }
    }

    private static void outputDatesAndFrequencyForTemperature(String day) {
        int occurrences = Collections.frequency(daysAbove20, day);
        String date = day.split(" ")[0];
        System.out.println(String.format("It will be Above 20 Degrees on this Date %s for %s times that Day", date, occurrences));
    }

    private static void outputSunnyDaysAndTimes(String day) {
        String date = day.split(" ")[0];
        String time = day.split(" ")[1];
        System.out.println(String.format("It will be Sunny on this Date %s at this Time %s", date, time));
    }
}
