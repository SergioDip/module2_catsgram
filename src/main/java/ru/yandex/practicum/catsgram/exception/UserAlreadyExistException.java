package ru.yandex.practicum.catsgram.exception;

public class UserAlreadyExistException extends Exception {

	public UserAlreadyExistException(final String message) {
		super(message);
	}
}
