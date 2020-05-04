package com.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.DAO.UserDAO;
import com.DBConnection.DBConnect;
import com.model.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public int addUser(User u) {
		int status = -1;
		Connection con = null;
		try {

			con = DBConnect.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into user(firstname, middlename, lastname,email, password, addressLine, street, city, state, zipcode, profileimage,status) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getMiddleName());
			ps.setString(3, u.getLastName());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getPassword());
			ps.setString(6, u.getAddressline());
			ps.setString(7, u.getStreet());
			ps.setString(8, u.getCity());
			ps.setString(9, u.getState());
			ps.setString(10, u.getZipcode());
			ps.setByte(11, u.getProfileImage());
			ps.setString(12, u.getStatus());

			status = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Error occured in addUser" + ex.getMessage());
		}
		return status;
	}

	@Override
	public int updateUser(User u) {
		int status = 0;
		Connection con = null;
		try {

			con = DBConnect.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update user set firstname=?, middlename=?, lastname=?,email=?, password=?, addressline=?, street=?, city=?, state=?, zipcode=?, profileImage=?,status=? where userId=?");
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getMiddleName());
			ps.setString(3, u.getLastName());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getPassword());
			ps.setString(6, u.getAddressline());
			ps.setString(7, u.getStreet());
			ps.setString(8, u.getCity());
			ps.setString(9, u.getState());
			ps.setString(10, u.getZipcode());
			ps.setByte(11, u.getProfileImage());
			ps.setString(12, u.getStatus());

			status = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Error occured while update user");
		}
		return status;
	}

	@Override
	public int deleteUser(User u) {

		int status = 0;
		Connection con = null;
		try {

			con = DBConnect.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from user where userId=?");
			ps.setInt(1, u.getUserId());
			status = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Error occured while delete user");
		}
		return status;
	}

	@Override
	public List<User> getListOfUser() {

		List<User> list = new ArrayList<User>();

		try {

			Connection con = DBConnect.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from user");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				User u = new User();
				u.setFirstName(rs.getString("firstname"));//from db table "firstname"
				u.setMiddleName(rs.getString("middlename"));
				u.setLastName(rs.getString("lastname"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				u.setAddressline(rs.getString("addressline"));
				u.setStreet(rs.getString("street"));
				u.setCity(rs.getString("city"));
				u.setState(rs.getString("state"));
				u.setZipcode(rs.getString("zipcode"));
				u.setProfileImage(rs.getByte("profileimage"));
				u.setStatus(rs.getString("status"));

				list.add(u);

			}

		} catch (Exception ex) {
			System.out.println("Error in getListOfUser");
			ex.printStackTrace();
		}

		return list;
	}

	public User getUser(String email, String password) {

		User u = null;
		Connection con = null;
		try {
			con = DBConnect.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from user where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				u = new User();
				u.setFirstName(rs.getString("firstName"));
				u.setMiddleName(rs.getString("middleName"));
				u.setLastName(rs.getString("lastname"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				u.setAddressline(rs.getString("addressline"));
				u.setStreet(rs.getString("street"));
				u.setCity(rs.getString("city"));
				u.setState(rs.getString("state"));
				u.setZipcode(rs.getString("zipcode"));
				u.setProfileImage(rs.getByte("image"));
				u.setStatus(rs.getString("userstatus"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return u;
	}
}
