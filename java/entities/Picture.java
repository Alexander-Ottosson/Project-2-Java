package entities;

public class Picture {
    private int id;
    private byte[] data;
    private int mechId;

    public Picture(){
        super();
    }
        public Picture(int id, int mechId) {
        super();
            this.id = id;
            this.mechId = mechId;
        }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public byte[] getData() {
        return data;
    }
    public void setData(byte[] data) {
        this.data = data;
    }
    public int getMechId() {
        return mechId;
    }
    public void setMechId(int mechId) {
        this.mechId = mechId;
    }

}
