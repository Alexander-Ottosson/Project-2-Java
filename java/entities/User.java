package entities;

public class User {
    private int id;
    private String username;
    private String password;
    private Boolean isPilot;
    private Boolean isAdmin;

    public User() {
        super();
    }
        public User(int Id, String username, String password, Boolean isPilot, Boolean isAdmin) {
        super();
                this.id = id;
                this.username = username;
                this.password =  password;
                this.isPilot = isPilot;
                this.isAdmin = isAdmin;
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
        public Boolean getIsPilot() {
            return isPilot;
        }
        public void setIsPilot(Boolean isPilot) {
            this.isPilot = isPilot;
        }
        public Boolean getIsAdmin() {
            return isAdmin;
        }
        public void setIsAdmin(Boolean isAdmin) {
            this.isAdmin = isAdmin;
        }

}

