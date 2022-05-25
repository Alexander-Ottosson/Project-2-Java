package services;

import daos.PilotDao;
import entities.Pilot;

import java.util.List;

public class PilotServiceImpl implements PilotService{

    private PilotDao pd;

    public PilotServiceImpl(PilotDao pd) {
        this.pd =pd;
    }
    @Override
    public Pilot readPilot(int pilotId) {
        return pd.readPilot(pilotId);
    }

    @Override
    public Pilot readPilot2(int pilot2Id) {
        return pd.readPilot2(pilot2Id);
    }

    @Override
    public List<Pilot> readAllPilots() {
        return pd.readAllPilots();
    }
}
