package past.project.jdbcReview.test;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

import past.project.jdbcReview.bean.*;
import past.project.jdbcReview.dao.*;
import past.project.jdbcReview.dao.impl.OrderDaoImpl;

public class OrderTest {

	private OrderDao orDao = new OrderDaoImpl();

	@Test
	public void test1() {
		Random rand = new Random();
		int userId = rand.nextInt(100);
		ArrayList<Order> orderList = orDao.getOrdersByUserId(userId);
		if (orderList != null) {
			System.out.println("There are totally " + orderList.size() + " order(s) for user with user id " + userId);
		} else {
			System.out.println("There is no order for user with user id " + userId);
		}
	}

	@Test
	public void test2() {
		
		Random rand = new Random();
		int orderId = rand.nextInt(100);
		Order or = orDao.getOrderByOrderId(orderId);
		if(or!=null){
			System.out.println(or.toString());
		}else{
			System.out.println("There is no order with order id "+orderId);
		}
		
	}
}
