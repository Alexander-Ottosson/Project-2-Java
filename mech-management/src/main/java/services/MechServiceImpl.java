package services;

import daos.MechDao;
import entities.Mech;

import java.util.List;

public class MechServiceImpl implements MechService{

    private MechDao md;

    public MechServiceImpl(MechDao md) {
        this.md = md;
    }
    @Override
    public Mech createMech(Mech m) {
        return md.createMech(m);
    }

    @Override
    public Mech readMech(int mechId) {
        return md.readMech(mechId);
    }

    @Override
    public List<Mech> readAllMechs() {
        return md.readAllMechs();
    }

    @Override
    public Mech updateMech(Mech change) {
        return md.updateMech(change);
    }

    @Override
    public Mech deleteMech(int mechId) {
        return md.deleteMech(mechId);
    }
}
