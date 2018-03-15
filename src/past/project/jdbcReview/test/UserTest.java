package past.project.jdbcReview.test;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

import past.project.jdbcReview.bean.User;
import past.project.jdbcReview.dao.*;
import past.project.jdbcReview.dao.impl.UserDaoImpl;

public class UserTest {

	private UserDao usDao = new UserDaoImpl();

	@Test
	public void test1() {

		ArrayList<User> users = usDao.getAllUsers();
		if (users != null) {

			System.out.println("Totally there are " + users.size() + " users");

		} else {
			System.out.println("No user remained in database");
		}

	}

	@Test
	public void test2() {
		Random rand = new Random();
		int randomUserId = rand.nextInt(100);
		User user = usDao.getUserById(randomUserId);
		if (user != null) {
			System.out.println(user.toString());
		} else {
			System.out.println("No user remained in database with the id of " + randomUserId);
		}
	}
}
