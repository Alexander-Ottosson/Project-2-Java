package entities;

import enums.AUTHS;
import enums.METHODS;

import java.util.Objects;

public class User {
    private int id;
    private String username;
    private String password;

    private METHODS contact;

    private String info;
    private AUTHS role;

    public User() {
//        super();
    }
    public User(int id, String username, String password, METHODS contact, String info, AUTHS role) {
//        super();
        this.id = id;
        this.username = username;
        this.password =  password;
        this.contact = contact;
        this.info = info;
        this.role = role;

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public METHODS getContact() {
        return contact;
    }
    public void setContact(METHODS contact) {
        this.contact = contact;
    }

    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public AUTHS getRole() {
        return role;
    }
    public void setRole(AUTHS role) {
        this.role = role;
    }


    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getPassword(), getContact(), getInfo(), getRole());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password=" + password +
                ", contact=" + contact +
                ", info=" + info +
                ", role=" + role +
                '}';
    }
}
