package entities;

import enums.AUTHS;
import enums.METHODS;

import java.util.Objects;

public class User {
    private int userId;
    private String username;
    private String password;

    private METHODS contact;

    private String info;
    private AUTHS role;

    public User() {
        super();
    }
        public User(int userId, String username, String password, METHODS contact, String info, AUTHS role) {
        super();
                this.userId = userId;
                this.username = username;
                this.password =  password;
                this.contact = contact;
                this.info = info;
                this.role = role;

        }
        public int getUserId() {
            return userId;
        }
        public void setUserId(int userId) {
            this.userId = userId;
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
        return Objects.hash(getUserId(), getUsername(), getPassword(), getContact(), getInfo(), getRole());
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password=" + password +
                ", contact=" + contact +
                ", info=" + info +
                ", role=" + role +
                '}';
    }

}

