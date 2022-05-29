package entities;

public class Picture {
    private int pictureId;
    private byte file;
    private int mechId;

    public Picture(){
        super();
    }
    public Picture(int pictureId, int mechId, byte file) {
        super();
        this.pictureId = pictureId;
        this.mechId = mechId;
        this.file = file;
    }
    public int getPictureId() {
        return pictureId;
    }
    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }
    public byte getFile() {
        return file;
    }
    public void setFile(byte file) {
        this.file = file;
    }
    public int getMechId() {
        return mechId;
    }
    public void setMechId(int mechId) {
        this.mechId = mechId;
    }

}

