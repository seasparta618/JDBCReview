package past.project.jdbcReview.dao;

import past.project.jdbcReview.bean.*;
import java.util.*;

public interface OrderDao {

	public ArrayList<Order> getOrdersByUserId(Integer userId);

	public Order getOrderByOrderId(Integer orderId);

}
