package task_4;

import task_models.User;

import java.lang.reflect.Field;

public class ReflectionTask {

	//Write a method which can work with any object using reflection. End user should be able use it like this:
	//		get(object,”fieldName”) - return value of field
	//		put(object,”fieldName”,value) - put the value to field
	//		clear(object,”fieldName”) - put null or 0 to the field.
	//Methods should throw exceptions with explanations if something is wrong.

	public static void main(String[] args) {
		String fieldName = "password";
		User user = new User("usrname", "pass123", 28);
		System.out.println(get(user, fieldName));
		System.out.println(get(put(user, fieldName, "newpass123"), fieldName));
		System.out.println(get(clear(user, fieldName), fieldName));
	}

	public static Object get(Object obj, String fieldName) {
		if (obj == null || fieldName == null) {
			throw new IllegalArgumentException("One of your args is null");
		}
		try {
			Field field = obj.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			return field.get(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Object put(Object obj, String fieldName, Object fieldParam) {
		if (obj == null || fieldName == null) {
			throw new IllegalArgumentException("One of your args is null");
		}
		try {
			Field field = obj.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(obj, fieldParam);
			return obj;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Object clear(Object obj, String fieldName) {
		if (obj == null || fieldName == null) {
			throw new IllegalArgumentException("One of your args is null");
		}
		try {
			Field field = obj.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(obj, null);
			return obj;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
