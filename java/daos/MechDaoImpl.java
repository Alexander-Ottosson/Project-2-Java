package daos;

import entities.Mech;
import enums.PILOTS;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MechDaoImpl implements MechDao{

    private PreparedStatement stmt;

    private static Logger Log = LogManager.getLogger("Dao");

    private ConnectionUtil connUtil;

    public MechDaoImpl(ConnectionUtil connectionUtil) {
        super();
        connUtil = connectionUtil;
    }

    @Override
    public int createMech(Mech mech) throws SQLException {
        int result;

        try (Connection conn = connUtil.createConnection()) {
            Log.info("Received request to insert mech: " + mech.getMechId());

            String sql = "INSERT INTO mech VALUES (Default,?,?,?,?,?,?,?,?,?,?) RETURNING mech_id;";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, mech.getMake());
            stmt.setString(2, mech.getModel());
            stmt.setInt(3, mech.getYear());
            stmt.setString(4, mech.getColor());
            stmt.setDouble(5, mech.getMaxSpeed());
            stmt.setDouble(6, mech.getWeight());
            stmt.setDouble(7, mech.getHeight());
            stmt.setString(8, mech.getDescription());
            stmt.setString(9, mech.getRequiredPilots().toString());



            ResultSet rs = stmt.executeQuery();
            rs.next();
            result = rs.getInt(1);
            Log.info("Request completed, generated mech mech_id: " + result);

        } catch (SQLException e) {
            Log.warn("SQLException thrown in create related to mech: " + mech.getMechId(), e);
            throw e;
        }

        return result;
    }

    @Override
    public Mech readMech(int mechId) throws SQLException {
        Mech result = null;

        try (Connection conn = connUtil.createConnection()) {
            Log.info("Received request to retrieve mech with mech_id: " + mechId);

            String sql = "SELECT * FROM mech WHERE mech_id = ?;";
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, mechId);

            ResultSet rs = stmt.executeQuery();
            rs.next();
            result = new Mech(rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getInt(4), rs.getString(5),
                    rs.getDouble(6), rs.getDouble(7),  rs.getDouble(8),
                    rs.getString(9), PILOTS.valueOf(rs.getString(10)),
                    rs.getBoolean(11));

            Log.info("Request completed, retrieved mech: " + result.getMechId());

        } catch (SQLException e) {
            Log.warn("SQLException thrown in read for mech with mech_id: " + mechId, e);
            throw e;
        }

        return result;
    }


    @Override
    public List<Mech> readAllMechs() throws SQLException {
        return null;
    }

    @Override
    public boolean updateMech(Mech mech) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteMech(int mechId) throws SQLException {
        return false;
    }
}
