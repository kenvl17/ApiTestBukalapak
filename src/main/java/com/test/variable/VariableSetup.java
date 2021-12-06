/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.variable;

import com.test.wrapper.PostWrapper;
import static java.lang.Math.random;

/**
 *
 * @author kentvanlim
 */
public class VariableSetup {

    PostWrapper input;
    public PostWrapper inputPost() {
        input = new PostWrapper();
        input.setBody("Post that contains characters");
        input.setTitle("My first post");
        input.setId(120);
        return input;
    }
}
