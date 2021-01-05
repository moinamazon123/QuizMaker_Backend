package com.quizApp.utility;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SMSUtil {
   /* public static void main(String[] args) {
        // Your apikey key
        String apiKey = "68686868686";
        // OR
        String userId = "moinuser";
        String password = "ggjjggjgjj";

        // Send Method
        String sendMethod = "simpleMsg";

        // Message type text/unicode/flash
        String msgType = "text";

        // Multiple mobiles numbers separated by comma
        String mobile = "87777";
        // Your approved sender id
        String senderId = "SENDER";
        // Your DLT Principal Entity id (only Indian Customers)
        String dltEntityId = "123xxxxxxxxxxx";
        // Your message to terminate, URLEncode the content
        String msg = "This is a test message in Java";
        // response format
        String format = "json";

        // Prepare Url
        URLConnection myURLConnection = null;
        URL myURL = null;
        BufferedReader reader = null;

        // URL encode message
        String urlencodedmsg = "";
        try {
            urlencodedmsg = URLEncoder.encode(msg, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            System.out.println("Exception while encoding msg");
            e1.printStackTrace();
        }

        // API End Point
        String mainUrl = "https://www.smsgateway.center/SMSApi/rest/send?";

        // API Paramters
        StringBuilder sendSmsData = new StringBuilder(mainUrl);
        sendSmsData.append("apiKey=" + apiKey);
        sendSmsData.append("&userId=" + userId);
        sendSmsData.append("&password=" + password);
        sendSmsData.append("&sendMethod=" + sendMethod);
        sendSmsData.append("&msgType=" + msgType);
        sendSmsData.append("&mobile=" + mobile);
        sendSmsData.append("&senderId=" + senderId);
        sendSmsData.append("&dltEntityId=" + dltEntityId);
        sendSmsData.append("&msg=" + urlencodedmsg);
        sendSmsData.append("&format=" + format);
        // final string
        mainUrl = sendSmsData.toString();
        try {
            // prepare connection
            myURL = new URL(mainUrl);
            myURLConnection = myURL.openConnection();
            myURLConnection.connect();
            reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
            // reading response
            String response;
            while ((response = reader.readLine()) != null)
                // print response
                System.out.println(response);

            // finally close connection
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

}