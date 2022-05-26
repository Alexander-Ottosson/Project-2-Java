package daos;

import entities.User;
import enums.AUTHS;
import enums.METHODS;
import util.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{

    public static Connection conn = JDBCConnection.getConnection();

    @Override
    public User createUser(User u) {
        String sql = "INSERT INTO user VALUES (Default,?,?,?::METHODS,?,?::AUTHS) RETURNING *";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getContact().toString());
            ps.setString(4, u.getInfo());
            ps.setString(5, u.getRole().toString());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildUser(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User readUser(int id) {
        String sql = "SELECT * FROM user WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<User> readAllUsers() {
        String sql = "SELECT * FROM user";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            List<User> users = new ArrayList<>();

            while(rs.next()) {
                users.add(buildUser(rs));
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public User updateUser(User change) {
        try {
            String sql = "UPDATE user SET username=?, password=?, contact=?::METHODS, info=?," +
                    " role=?::AUTHS WHERE id = ? RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, change.getUsername());
            ps.setString(2, change.getPassword());
            ps.setString(3, change.getContact().toString());
            ps.setString(4, change.getInfo());
            ps.setString(5, change.getRole().toString());
            ps.setInt(7, change.getId());

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return buildUser(rs);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User deleteUser(int id) {
        try {
            String sql = "DELETE FROM user WHERE id = ? RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public User loginUser(String username, String password) {
        try {
            String sql = "SELECT * FROM user WHERE username = ? AND password = ? RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    private User buildUser(ResultSet rs) throws SQLException {
        User u = new User();
        u.setId(rs.getInt("id"));
        u.setUsername(rs.getString("username"));
        u.setPassword(rs.getString("password"));
        u.setContact(METHODS.valueOf(rs.getString("contact")));
        u.setInfo(rs.getString("info"));
        u.setRole(AUTHS.valueOf(rs.getString("role")));

        return u;
    }
}
