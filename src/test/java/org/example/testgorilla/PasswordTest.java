package org.example.testgorilla;

import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

class PasswordTest {
    Password password = new Password();

    @Test
    public void shouldReturnCorrectPassword1() {
        String correctPassword = password.controlStringPasswords(new String[]{"P@sswOD7", "20PassW20", "PASS6word"}, "4dro6");
        assertEquals(correctPassword,"PASS6word");
    }
    @Test
    public void shouldReturnCorrectPassword2(){

        String correctPassword = password.controlStringPasswords(new String[]{"theBestpassword", "myPassword#3"}, "1dro0");
        assertEquals(correctPassword,"theBestpassword");
    }

    @Test
    public void shouldReturnCorrectPassword3(){
        String correctPassword = password.controlStringPasswords(new String[]{"MyPassword2", "crazyPassword1#$%",}, "1%$#1");
        assertEquals(correctPassword,"crazyPassword1#$%");
    }
    @Test
    public  void shouldReturnNoValidPassword(){
        String NoValidPassword = password.controlStringPasswords(new String[]{"P@sswOD7", "20PassW20", "PASS7word"}, "4dro6");
        assertNotEquals(NoValidPassword,"PASS6word");
    }
    @Test
    public void shouldReturnEmptyStringBadControlString(){
        String badControlString = password.controlStringPasswords(new String[]{"luckyPASSWORD#$$$", "luckyDay666"}, "6pass7");
        assertEquals(badControlString,"");
    }


}