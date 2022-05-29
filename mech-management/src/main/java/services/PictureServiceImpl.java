package services;

import daos.PictureDao;
import entities.Picture;

import java.util.List;

public class PictureServiceImpl implements PictureService{

    private PictureDao pd;

    public PictureServiceImpl(PictureDao pd) {
        this.pd = pd;
    }

    @Override
    public Picture createPicture(Picture p) {
        return pd.createPicture(p);
    }

    @Override
    public Picture readPicture(int pictureId) {
        return pd.readPicture(pictureId);
    }

    @Override
    public List<Picture> readAllPictures() {
        return pd.readAllPictures();
    }

    @Override
    public Picture updatePicture(Picture change) {
        return pd.updatePicture(change);
    }

    @Override
    public Picture deletePicture(int pictureId) {
        return pd.deletePicture(pictureId);
    }
}
