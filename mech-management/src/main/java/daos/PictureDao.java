package daos;

import entities.Picture;

import java.util.List;

public interface PictureDao {

    public Picture createPicture(Picture p);

    public Picture readPicture(int pictureId);

    public List<Picture> readAllPictures();

    public Picture updatePicture(Picture change);

    public Picture deletePicture(int pictureId);
}

