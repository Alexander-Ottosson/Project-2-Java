package daos;

import entities.Pilot;
import enums.MISSIONS;
import util.JDBCConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PilotDaoImpl implements PilotDao{
    public static Connection conn = JDBCConnection.getConnection();



    @Override
    public Pilot readPilot(int pilotId) {
        String sql = "SELECT * FROM pilot WHERE pilot_id = ?";

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pilotId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return buildPilot(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Pilot readPilot2(int pilot2Id) {
        String sql = "SELECT * FROM pilot WHERE pilot2_id = ?";

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pilot2Id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return buildPilot(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Pilot> readAllPilots(){
        String sql = "SELECT * FROM pilot";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Pilot> pilots = new ArrayList<>();

            while(rs.next()) {
                pilots.add(buildPilot(rs));
            }

            return pilots;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Pilot buildPilot(ResultSet rs) throws SQLException {
        Pilot pilot = new Pilot();
        pilot.setPilotId(rs.getInt("pilot_id"));
        pilot.setPilot2Id(rs.getInt("pilot2_id"));
        pilot.setMissionType(MISSIONS.valueOf(rs.getString("mission_type")));
        pilot.setConfidential(rs.getBoolean("confidential"));

        return pilot;
    }

}
