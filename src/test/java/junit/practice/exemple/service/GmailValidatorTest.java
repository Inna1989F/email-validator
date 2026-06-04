package junit.practice.exemple.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GmailValidatorTest {
    private EmailValidator emailValidator = new GmailValidator();
@Test
void containsGmailDomen_Ok(){
    String email = "valid@gmail.com";
   boolean actual = emailValidator.isValid(email);
   assertTrue(actual);
}
@Test
    void startWithNumber_NotOk() {
    String email = "456@gmail.com";
    boolean actual = emailValidator.isValid(email);
    assertFalse(actual);
}
@Test
    void startWithSymbol_NotOk() {
    String email = "&hallo@gmail.com";
    boolean actual = emailValidator.isValid(email);
    assertFalse(actual);
}

@Test
    void containsSymbolsAndLetter_Ok(){
    String email = "val456&id@gmail.com";
    boolean actual = emailValidator.isValid(email);
    assertTrue(actual);
}
@Test
    void nullValue_NotOk() {
    assertThrows(NullPointerException.class, () -> {
        emailValidator.isValid(null);
    });
}
    @Test
    void notGmail_NotOk() {
        assertFalse(emailValidator.isValid("test@yahoo.com"));
    }
}
