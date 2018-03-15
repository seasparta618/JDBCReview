package past.project.jdbcReview.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import past.project.jdbcReview.bean.Order;
import past.project.jdbcReview.dao.JDBCConnection;
import past.project.jdbcReview.dao.OrderDao;

public class OrderDaoImpl implements OrderDao {

	@Override
	public ArrayList<Order> getOrdersByUserId(Integer userId) {
		// TODO Auto-generated method stub
		String sql = "select * from orders where user_id = ?";
		PreparedStatement pstmt = null;
		Connection conn = JDBCConnection.getCon();
		ResultSet rs = null;
		ArrayList<Order> orderList = new ArrayList<Order>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setProductNumber(rs.getString("number"));
				order.setUserId(rs.getInt("user_id"));
				order.setCreateTime(rs.getString("createtime"));
				order.setNote(rs.getString("note"));
				orderList.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.returnCon(conn);
		}
		if (!orderList.isEmpty()) {
			return orderList;
		}
		return null;
	}

	@Override
	public Order getOrderByOrderId(Integer orderId) {
		// TODO Auto-generated method stub
		String sql = "select * from orders where id = ?";
		PreparedStatement pstmt = null;
		Connection conn = JDBCConnection.getCon();
		ResultSet rs = null;
		Order order = new Order();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				order.setId(rs.getInt("id"));
				order.setProductNumber(rs.getString("number"));
				order.setUserId(rs.getInt("user_id"));
				order.setCreateTime(rs.getString("createtime"));
				order.setNote(rs.getString("note"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCConnection.returnCon(conn);
		}
		if(order.getId()==null){
			return null;
		}
		return order;
	}

}
