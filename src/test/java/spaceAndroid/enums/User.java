package spaceAndroid.enums;

/**
 * Created by raihan on 10/11/16.
 */
public enum User {
    INVALID("testbaru10@mailinator.com","lalala");

    private String email;
    private String password;

    User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
