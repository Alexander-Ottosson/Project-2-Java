package entities;

import enums.MISSIONS;

public class Pilot {
    private int pilotId;
    private int pilot2Id;
    private MISSIONS missionType;
    private Boolean confidential;

    public Pilot() {
        super();
    }
    public Pilot(int pilotId, int pilot2Id, MISSIONS missionType, Boolean confidential) {
        this.pilotId = pilotId;
        this.pilot2Id = pilot2Id;
        this.missionType = missionType;
        this.confidential = confidential;
    }
    public int getPilotId() {
        return pilotId;
    }
    public void setPilotId(int pilotId) {
        this.pilotId = pilotId;
    }
    public int getPilot2Id() {
        return pilot2Id;
    }
    public void setPilot2Id(int pilot2Id) {
        this.pilot2Id = pilot2Id;
    }
    public MISSIONS getMissionType() {
        return missionType;
    }
    public void setMissionType(MISSIONS missionType) {
        this.missionType = missionType;
    }
    public Boolean getConfidential() {
        return confidential;
    }
    public void setConfidential(Boolean confidential) {
        this.confidential = confidential;
    }
}

