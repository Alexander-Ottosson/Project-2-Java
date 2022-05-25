package daos;

import entities.Pilot;

import java.sql.SQLException;
import java.util.List;

public interface PilotDao {


    public Pilot readPilot(int pilotId);

    public Pilot readPilot2(int pilot2Id);

    public List<Pilot> readAllPilots();

}

