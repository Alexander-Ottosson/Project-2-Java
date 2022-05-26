package daos;

import entities.Mech;
import java.util.List;

public interface MechDao {

    public Mech createMech(Mech m);

    public Mech readMech(int mechId);

    public List<Mech> readAllMechs();

    public Mech updateMech(Mech change);

    public Mech deleteMech(int mechId);

}

