package daos;

import entities.Mech;
import java.sql.SQLException;
import java.util.List;

public interface MechDao {

    public int createMech(Mech mech) throws SQLException;

    public Mech readMech(int id) throws SQLException;

    public List<Mech> readAllMechs() throws SQLException;

    public boolean updateMech(Mech mech) throws SQLException;

    public boolean deleteMech(int id) throws SQLException;

}
