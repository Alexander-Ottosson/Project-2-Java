package entities;
import enums.cMethod;

public class ContactInfo {
    private int id;
    private int userId;
    private cMethod contact;
    private String info;

    public ContactInfo() {
        super();
    }
    public ContactInfo(int id, int userId, cMethod contact, String info) {
        this.id = id;
        this.userId =userId;
        this.contact = contact;
        this.info = info;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public cMethod getContact() {
        return contact;
    }
    public void setContact(cMethod contact) {
        this.contact = contact;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
}
