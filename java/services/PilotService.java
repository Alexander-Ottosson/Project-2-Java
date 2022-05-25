package services;

import entities.Pilot;

import java.util.List;

public interface PilotService {
    public Pilot readPilot(int pilotId);
    public Pilot readPilot2(int pilot2Id);
    public List<Pilot> readAllPilots();
}
