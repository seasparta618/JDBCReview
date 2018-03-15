package past.project.jdbcReview.dao;

import java.util.*;
import past.project.jdbcReview.bean.*;

public interface UserDao {

	public ArrayList<User> getAllUsers();

	public User getUserById(Integer userId);
}
