/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.runner;

import com.test.function.Function;
import io.restassured.RestAssured;
import org.json.JSONException;

/**
 *
 * @author kentvanlim
 */
public class MainRunner {
        static String baseURI = "https://jsonplaceholder.cypress.io/posts";
        public static void main(String[]args) throws JSONException{   
              RestAssured.baseURI = baseURI;
              Function func = new Function();
              func.getData();
              func.addPost();
        }
        
}
