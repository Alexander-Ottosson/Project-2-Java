package daos;
import entities.Picture;
import java.sql.SQLException;
import java.util.List;

public interface PictureDao {

    public int createPicture(Picture picture) throws SQLException;

    public Picture readPicture(int id) throws SQLException;

    public List<Picture> readAllPictures() throws SQLException;

    public boolean updatePicture(Picture picture) throws SQLException;

    public boolean deletePicture(int id) throws SQLException;
}
