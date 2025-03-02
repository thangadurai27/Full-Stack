package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;
import utility.DBconnection;

public class UserDAOImpl implements UserDAO {
    @Override
    public User findUserByName(String name) {
        String query = "SELECT * FROM user WHERE name=?";
        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
             
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setMobileNumber(rs.getString("mobileNumber"));  // Updated to match column name
                user.setRole(rs.getString("role"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

	@Override
	public User findUserByName(String name, String password) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
