package services.JWT.models;

public class Jwt {
    private String token;

    public Jwt() {

    }

    public Jwt(String token) {
        this.token = token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
