/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.function;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.helper.StaticRequestsHelper;
import com.test.variable.VariableSetup;
import com.test.wrapper.PostWrapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author kentvanlim
 */
public class Function {
    VariableSetup set = new VariableSetup();
    
    public String addPost() throws JSONException{
        String jsonResult = "";
        String result ="";
        try {
            jsonResult = StaticRequestsHelper.post(set.inputPost(), "", 200);               
             result =  StaticRequestsHelper.generateReturnResultPost(jsonResult);
        } catch (JsonProcessingException jsonEx) {
            jsonEx.printStackTrace();
        }
        return result;
    }


    public String getData() throws JSONException {
       String jsonResult = "";
       String result ="";
        try {
            jsonResult = StaticRequestsHelper.get("", 200);
          result =  StaticRequestsHelper.generateReturnResultGet(jsonResult);
          
        } catch (JsonProcessingException jsonEx) {
            jsonEx.printStackTrace();
        }
          return result;
    }
  

}
