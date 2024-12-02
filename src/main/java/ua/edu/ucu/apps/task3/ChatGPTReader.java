package ua.edu.ucu.apps.task3;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.json.JSONObject;

public class ChatGPTReader {

    private static final String API_KEY = "ваш_ключ_OpenAI_API";

    public String getSummary(String prompt) {
        try {
            URL url = new URL("https://api.openai.com/v1/completions");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
            connection.setDoOutput(true);

            // Формуємо запит
            JSONObject requestBody = new JSONObject();
            requestBody.put("model", "text-davinci-003");
            requestBody.put("prompt", prompt);
            requestBody.put("max_tokens", 100);
            requestBody.put("temperature", 0.7);

            // Надсилаємо запит
            try (OutputStream os = connection.getOutputStream()) {
                os.write(requestBody.toString().getBytes(StandardCharsets.UTF_8));
            }

            // Отримуємо відповідь
            if (connection.getResponseCode() == 200) {
                Scanner scanner = new Scanner(connection.getInputStream()).useDelimiter("\\Z");
                String response = scanner.next();
                JSONObject jsonResponse = new JSONObject(response);
                return jsonResponse.getJSONArray("choices").getJSONObject(0).getString("text").trim();
            } else {
                return "Error: " + connection.getResponseCode();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to retrieve data from ChatGPT.";
        }
    }
}
