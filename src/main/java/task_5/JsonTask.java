package task_5;

class JsonTask {
	//Make some complex models with few fields.
	//Make it serializable.
	//Read some json from “input.json”
	//and deserialize it to POJO.
	//Then change a few fields and save it to “output.json”.

	public static void main(String[] args) {
		JsonUser user = new JsonUser("sur", "asd", 1000);
		String userJson = user.asJson().toString();
		System.out.println(userJson);
		System.out.println(user.parseJsonFromString(user.getClass(), userJson));
	}
}

