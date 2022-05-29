package Repo;

import Models.Mech;
import util.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MechRepoImpl implements MechRepo {

    public static Connection conn = JDBCConnection.getConnection();
    @Override
    public List<Mech> getAllMechs() {
        String sql = "SELECT * FROM mech WHERE confidential=false";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Mech> meches = new ArrayList<>();

            while(rs.next()) {
                meches.add(buildMech(rs));
            }

            return meches;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private Mech buildMech(ResultSet rs) throws SQLException {
        Mech m = new Mech();
        m.setMechId(rs.getInt("id"));
        m.setMake(rs.getString("make"));
        m.setModel(rs.getString("model"));
        m.setYear(rs.getString("year"));
        m.setColor(rs.getString("color"));
        m.setMaxSpeed(rs.getDouble("max_speed"));
        m.setWeight(rs.getDouble("weight"));
        m.setHeight(rs.getDouble("height"));
        m.setDes(rs.getString("description"));
        m.setCp(rs.getInt("current_pilot"));
        m.setPc(rs.getInt("pilot_count"));
        m.setAva(rs.getBoolean("available"));
        m.setCon(rs.getBoolean("confidential"));


        return m;
    }
}
