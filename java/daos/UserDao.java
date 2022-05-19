package daos;
import entities.User;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {

        public int createUser(User user) throws SQLException;

        public User readUser(int id) throws SQLException;

        public List<User> readAllUsers() throws SQLException;

        public boolean updateUser(User user) throws SQLException;

        public boolean deleteUser(int id) throws SQLException;

        public User loginUser(String username, String password) throws SQLException;
    }

