package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.BankUser;

public class BankUserDaoImpl implements BankUserDao {
	private static final String username = "banks_db";
	private static final String password = "p4ssw0rd";
	private static final String url      = "jdbc:oracle:thin:@localhost:1521:xe";

	@Override
	public BankUser getBankUserByUsername(BankUser user) {
		BankUser dbUser = null;
		try (Connection con = DriverManager.getConnection(url, username, password);){
			String sql = "SELECT * FROM bank_user WHERE bu_username = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				dbUser = new BankUser(rs.getInt("BU_ID"),rs.getString("BU_USERNAME"),rs.getString("BU_FIRST_NAME"),
						rs.getString("BU_LAST_NAME"), rs.getString("BU_PASSWORD"));
				System.out.println(dbUser);
			};
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	return dbUser;
	}

}
