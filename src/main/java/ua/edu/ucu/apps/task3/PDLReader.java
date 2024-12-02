package ua.edu.ucu.apps.task3;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class PDLReader {

    private static final String API_KEY = "";

    public String getCompanyName(String linkSite) throws IOException {
        JSONObject jsonObject = getData(linkSite);
        return jsonObject.optString("name", "Unknown");
    }

    public String getCompanyDescription(String linkSite) throws IOException {
        JSONObject jsonObject = getData(linkSite);
        return jsonObject.optString("description", "No description available");
    }

    private JSONObject getData(String linkSite) throws IOException {
        URL url = new URL("https://api.peopledatalabs.com/v5/company/enrich?website=" + linkSite);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
        connection.connect();

        int statusCode = connection.getResponseCode();
        if (statusCode != 200) {
            throw new IOException("Error: Server returned HTTP response code " + statusCode);
        }

        String response = new Scanner(connection.getInputStream()).useDelimiter("\\Z").next();
        return new JSONObject(response);
    }
}
