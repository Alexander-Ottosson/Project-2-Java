package daos;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import util.ConnectionUtil;
import entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class UserDaoImpl implements UserDao {


        private PreparedStatement stmt;

        private static Logger Log = LogManager.getLogger("Dao");

        private ConnectionUtil connUtil;

        public UserDaoImpl(ConnectionUtil connectionUtil) {
            super();
            connUtil = connectionUtil;
        }

        @Override
        public int createUser(User user) throws SQLException {
            int result;

            try (Connection conn = connUtil.createConnection()) {
                Log.info("Received request to insert user: " + user.getUsername());

                String sql = "INSERT INTO user VALUES (Default,?,?,?,?) RETURNING id;";
                stmt = conn.prepareStatement(sql);

                stmt.setString(1, user.getUsername());
                stmt.setString(2, user.getPassword());
                stmt.setBoolean(3, user.getIsPilot());
                stmt.setBoolean(4, user.getIsAdmin());

                ResultSet rs = stmt.executeQuery();
                rs.next();
                result = rs.getInt(1);
                Log.info("Request completed, generated user id: " + result);

            } catch (SQLException e) {
                Log.warn("SQLException thrown in create related to user: " + user.getUsername(), e);
                throw e;
            }

            return result;
        }

        @Override
        public boolean deleteUser(int id) throws SQLException {
            boolean result = false;

            try (Connection conn = connUtil.createConnection()) {
                Log.info("Received request to delete user with id: " + id);

                String sql = "DELETE FROM user WHERE user_id = ?;";
                stmt = conn.prepareStatement(sql);

                stmt.setInt(1, id);

                result = (1 == stmt.executeUpdate());

                if (result) {
                    Log.info("Request completed, user with id: " + id + " was deleted.");
                } else
                    Log.warn("Request to delete user with id: " + id + " was NOT completed");

            } catch (SQLException e) {
                Log.warn("SQLException thrown in user delete for id: " + id, e);
                throw e;
            }

            return result;
        }

        @Override
        public User readUser(int id) throws SQLException {
            User result = null;

            try (Connection conn = connUtil.createConnection()) {
                Log.info("Received request to retrieve user with id: " + id);

                String sql = "SELECT * FROM user WHERE id = ?;";
                stmt = conn.prepareStatement(sql);

                stmt.setInt(1, id);

                ResultSet rs = stmt.executeQuery();
                rs.next();
                result = new User(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getBoolean(4), rs.getBoolean(5));

                Log.info("Request completed, retrieved user: " + result.getUsername());

            } catch (SQLException e) {
                Log.warn("SQLException thrown in read for user with id: " + id, e);
                throw e;
            }

            return result;
        }

    @Override
    public List<User> readAllUsers() throws SQLException {
        return null;
    }
        @Override
        public boolean updateUser(User user) throws SQLException {
            boolean result = false;

            try (Connection conn = connUtil.createConnection()) {
                Log.info("Received request to update user with id: " + user.getId());

                String sql = "UPDATE user SET username = ?, password = ?, isPilot = ?, isAdmin = ? WHERE id = ?;";
                stmt = conn.prepareStatement(sql);

                stmt.setString(1, user.getUsername());
                stmt.setString(2, user.getPassword());
                stmt.setBoolean(3, user.getIsPilot());
                stmt.setBoolean(4, user.getIsPilot());
                stmt.setInt(5, user.getId());

                result = (1 == stmt.executeUpdate());

                if (result) {
                    Log.info("Request completed, user with id: " + user.getId() + " was updated.");
                } else
                    Log.warn("Request to update user with id: " + user.getId() + " was NOT completed");

            } catch (SQLException e) {
                Log.warn("SQLException thrown in user update for id: " + user.getId(), e);
                throw e;
            }

            return result;
        }

        public User loginUser(String username, String password) throws SQLException {
            User result = null;

            try (Connection conn = connUtil.createConnection()) {
                Log.info("Received request to login user: " + username);

                String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
                stmt = conn.prepareStatement(sql);

                stmt.setString(1, username);
                stmt.setString(2, password);

                ResultSet rs = stmt.executeQuery();
                rs.next();
                result = new User(rs.getInt(1), rs.getString(2),rs.getString(3),
                        rs.getBoolean(4), rs.getBoolean(5));

                Log.info("Request completed, logged in user: " + result.getUsername());

            } catch (SQLException e) {
                Log.warn("SQLException thrown in user login: " + username, e);
                throw e;
            }

            return result;
        }
    }


