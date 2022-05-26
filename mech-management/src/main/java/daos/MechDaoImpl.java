package daos;

import entities.Mech;
import enums.PILOTS;
import util.JDBCConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MechDaoImpl implements MechDao {

    public static Connection conn = JDBCConnection.getConnection();

    @Override
    public Mech createMech(Mech m) {

        String sql = "INSERT INTO mech VALUES (Default,?,?,?,?,?,?,?,?,?,?) RETURNING *";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, m.getMake());
            ps.setString(2, m.getModel());
            ps.setInt(3, m.getYear());
            ps.setString(4, m.getColor());
            ps.setDouble(5, m.getMaxSpeed());
            ps.setDouble(6, m.getWeight());
            ps.setDouble(7, m.getHeight());
            ps.setString(8, m.getDescription());
            ps.setString(9, m.getRequiredPilots().toString());
            ps.setBoolean(10, m.getAvailable());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildMech(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Mech readMech(int mechId) {
        String sql = "SELECT * FROM mech WHERE mech_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, mechId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildMech(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Mech> readAllMechs() {

        String sql = "SELECT * FROM mech";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Mech> mechs = new ArrayList<>();

            while (rs.next()) {
                mechs.add(buildMech(rs));
            }
            return mechs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Mech updateMech(Mech change) {
        try {
            String sql = "UPDATE mech SET make=?, model=?, year=?, color=?, max_speed=?, weight=?, height=?," +
                    " description=?, required_pilots=?::PILOTS, available=? WHERE mech_id=? RETURNING *";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, change.getMake());
            ps.setString(2, change.getModel());
            ps.setInt(3, change.getYear());
            ps.setString(4, change.getColor());
            ps.setDouble(5, change.getMaxSpeed());
            ps.setDouble(6, change.getWeight());
            ps.setDouble(7, change.getHeight());
            ps.setString(8, change.getDescription());
            ps.setString(9, change.getRequiredPilots().toString());
            ps.setBoolean(10, change.getAvailable());
            ps.setInt(11, change.getMechId());


            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildMech(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Mech deleteMech(int mechId) {
         try {
              String sql = "DELETE FROM mech WHERE mech_id = ? RETURNING *";
              PreparedStatement ps = conn.prepareStatement(sql);

              ps.setInt(1, mechId);
              ResultSet rs = ps.executeQuery();

              if (rs.next()) {
                  return buildMech(rs);
              }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return null;
        }

    private Mech buildMech(ResultSet rs) throws SQLException {
         Mech m = new Mech();
         m.setMechId(rs.getInt("mech_id"));
         m.setMake(rs.getString("make"));
         m.setModel(rs.getString("model"));
         m.setYear(rs.getInt("year"));
         m.setColor(rs.getString("color"));
         m.setMaxSpeed(rs.getDouble("max_speed"));
         m.setWeight(rs.getDouble("weight"));
         m.setHeight(rs.getDouble("height"));
         m.setDescription(rs.getString("description"));
         m.setRequiredPilots(PILOTS.valueOf(rs.getString("required_pilots")));
         m.setAvailable(rs.getBoolean("available"));

         return m;
        }
    }




