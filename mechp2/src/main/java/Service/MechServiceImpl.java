package Service;

import Models.Mech;
import Repo.MechRepo;


import java.util.List;

public class MechServiceImpl implements MechService {
    private MechRepo mr;

    public MechServiceImpl(MechRepo mr) {
        this.mr = mr;
    }
    @Override
    public List<Mech> getAllMechs() {
        return mr.getAllMechs();

    }
}

