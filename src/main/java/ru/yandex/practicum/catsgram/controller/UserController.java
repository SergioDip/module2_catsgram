package ru.yandex.practicum.catsgram.controller;

import org.slf4j.*;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.exception.InvalidEmailException;
import ru.yandex.practicum.catsgram.exception.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.*;

import java.util.HashMap;

@RestController
@RequestMapping("/users")
public class UserController {

	private HashMap<String, User> users = new HashMap<>();
	private final static Logger log = LoggerFactory.getLogger(UserController.class);

	@GetMapping("/users")
	public HashMap<String, User> allUsers() {
		log.trace("Количество пользователей: {}", users.size());
		return users;
	}

	@PostMapping(value = "/users")
	public void createUser(@RequestBody User user) throws InvalidEmailException, UserAlreadyExistException {
		if (user.getEmail() == null || user.getEmail().isEmpty()) {
			throw new InvalidEmailException("Поле e-mail отсутствует");
		} else if (users.containsKey(user.getEmail())) {
			throw new UserAlreadyExistException("Такой пользователь уже существует");
		} else {
			log.trace("Сохранили объект: {}", user);
			users.put(user.getEmail(), user);
		}
	}

	@PutMapping(value = "/users")
	public void updateUser(@RequestBody User user) throws InvalidEmailException, UserAlreadyExistException {
		if (user.getEmail() == null || user.getEmail().isEmpty()) {
			throw new InvalidEmailException("e-mail пользователя не задан");
		} else if (!users.containsKey(user.getEmail())) {
			createUser(user);
		}else {
			users.put(user.getEmail(), user);
		}
	}
}