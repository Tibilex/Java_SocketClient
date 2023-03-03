package Models;

public class User {
    private long id;
    private String login;
    private String password;

    public User() {
        id = 0;
        login = "admin";
        password = "admin";
    }

    public  User(String mail, String password) {
        this.login = mail;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long _id) {
        this.id = _id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String _mail) {
        this.login = _mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String _password) {
        this.password = _password;
    }

    @Override
    public String toString() {
        return "User{" + "Id=" + id +
                ", Login='" + login + '\'' +
                ", Password='" + password + '\'' +
                '}';
    }
}
