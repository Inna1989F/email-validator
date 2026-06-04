package junit.practice.exemple.service;

public class GmailValidator implements EmailValidator {
    @Override
    public boolean isValid(String email) {
        if (email == null) {
            throw new NullPointerException();
        }
        if (!Character.isLetter(email.charAt(0))) {
            return false;
        }
        int atIndex = email.indexOf('@');
        if (atIndex == -1 || atIndex != email.lastIndexOf('@')) {
            return false;
        }

        return email.endsWith("gmail.com");
    }
}
