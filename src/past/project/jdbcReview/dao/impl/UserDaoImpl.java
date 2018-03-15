package past.project.jdbcReview.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import past.project.jdbcReview.bean.User;
import past.project.jdbcReview.dao.JDBCConnection;
import past.project.jdbcReview.dao.UserDao;

public class UserDaoImpl implements UserDao {

	@Override
	public ArrayList<User> getAllUsers() {
		// TODO Auto-generated method stub
		String sql = "select * from user";
		PreparedStatement pstmt = null;
		Connection conn = JDBCConnection.getCon();
		ResultSet rs = null;
		ArrayList<User> userList = new ArrayList<User>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				user.setBirthday(rs.getString("birthday"));
				user.setGender(rs.getString("sex"));
				user.setAddress(rs.getString("address"));
				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.returnCon(conn);
		}
		if(!userList.isEmpty()){
			return userList;
		}
		return null;
	}

	@Override
	public User getUserById(Integer userId) {
		// TODO Auto-generated method stub
		String sql = "select * from user where id = ?";
		PreparedStatement pstmt = null;
		Connection conn = JDBCConnection.getCon();
		ResultSet rs = null;
		User user = new User();
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,userId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				user.setBirthday(rs.getString("birthday"));
				user.setGender(rs.getString("sex"));
				user.setAddress(rs.getString("address"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCConnection.returnCon(conn);
		}
		if(user.getId()==null){
			return null;
		}
		return user;
	}

}
