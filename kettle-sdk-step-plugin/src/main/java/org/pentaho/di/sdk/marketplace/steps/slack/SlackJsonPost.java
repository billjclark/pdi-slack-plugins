package org.pentaho.di.sdk.marketplace.steps.slack;

import org.json.JSONObject;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SlackJsonPost {

    private final String serverUrl;
    private int responseCode;

    public SlackJsonPost(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public void post(String message) throws Exception {
        // Create a JSON object with the input string as its value
        JSONObject json = new JSONObject();
        json.put("text", message);

        // Convert the JSON object to a string
        String jsonString = json.toString();

        // Create a URL object from the server URL
        URL url = new URL(serverUrl);

        // Open an HTTP connection to the server
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        // Set the request method to POST and the content type to JSON
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");

        // Enable output for the connection
        conn.setDoOutput(true);

        // Get the output stream of the connection
        OutputStream os = conn.getOutputStream();

        // Write the JSON string to the output stream
        os.write(jsonString.getBytes());
        os.flush();
        os.close();

        // Get the response code from the server
        responseCode = conn.getResponseCode();

        // Print the response code
        System.out.println("Response code: " + responseCode);
    }

    public int getResponseCode() { return responseCode; };
}
