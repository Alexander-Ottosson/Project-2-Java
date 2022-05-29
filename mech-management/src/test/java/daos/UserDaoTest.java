package daos;

import entities.User;
import org.junit.jupiter.api.Test;
import static enums.AUTHS.ADMIN;
import static enums.METHODS.EMAIL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDaoTest {
    UserDao ud = new UserDaoImpl();

    @Test
    public void readUser() {

        int userId = 1;
        User actual = ud.readUser(userId);
        User expected = new User(1, "admin1","aPassword1",  EMAIL, "admin1@mech.management",
                ADMIN);

        assertEquals(expected, actual);

    }
}
