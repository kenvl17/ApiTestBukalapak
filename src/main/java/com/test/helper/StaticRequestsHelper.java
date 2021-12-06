/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.variable.VariableSetup;
import com.test.wrapper.PostWrapper;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author kentvanlim
 */
public class StaticRequestsHelper {

    static VariableSetup set = new VariableSetup();
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String get(String url, int statusCode) throws JsonProcessingException {
        String response = "";
        try {
            response = given()
                    .get(url)
                    .then()
                    .extract()
                    .asString();
        } catch (AssertionError e) {
            response = e.getMessage();
        }
        return response;
    }

    public static String generateReturnResultGet(String jsonString) throws JSONException {
        String result;
        jsonString = jsonString.replace("[", "");
        jsonString = jsonString.replace("[", "");
        JSONObject jObj = new JSONObject(jsonString);
        Object userId = jObj.get("userId");
        Object id = jObj.get("id");
        Object title = jObj.get("title");
        Object body = jObj.get("body");
        if (userId instanceof Integer && id instanceof Integer && title instanceof String && body instanceof String) {
            jsonString = "Valid";
        } else {
            jsonString = "Invalid";
        }
        return jsonString;
    }

    public static String post(Object body, String url, int statusCode) throws JsonProcessingException {
        String response = "";
        try {
            response = given()
                    .contentType(ContentType.JSON)
                    .body(objectMapper.writeValueAsString(body))
                    .post(url)
                    .then()
                    .extract()
                    .asString();

        } catch (AssertionError e) {
            e.printStackTrace();
            response = e.getMessage();
        }
        return response;
    }

    public static String generateReturnResultPost(String jsonString) throws JSONException {
        String result;
        JSONObject jObj = new JSONObject(jsonString);
        Object title = jObj.get("title");
        Object id = jObj.get("id");
        Object body = jObj.get("body");
        if (id.equals(set.inputPost().getId()) && title.equals(set.inputPost().getTitle()) && body.equals(set.inputPost().getBody())) {
            jsonString = "Valid";
        } else {
            jsonString = "Invalid";
        }
        return jsonString;
    }

}
