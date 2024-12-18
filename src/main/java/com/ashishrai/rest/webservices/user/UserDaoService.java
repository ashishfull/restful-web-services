package com.ashishrai.rest.webservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	private static int usersCount = 0;

	static {
		users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(25)));
		users.add(new User(++usersCount, "Jim", LocalDate.now().minusYears(20)));
	}

	public List<User> findAll() {
		return users;
	}

	public User findById(Integer id) {
		return users.stream().filter(user -> Objects.equals(user.getId(), id)).findFirst().orElseThrow(
				() -> new UserNotFoundException(String.format("User with the ID %s was not found to be existing", id)));
	}

	public void removeById(Integer id) {
		users.removeIf(user -> Objects.equals(user.getId(), id));
	}

	public User addUser(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}

}
