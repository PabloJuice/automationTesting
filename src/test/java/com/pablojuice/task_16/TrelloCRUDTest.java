package com.pablojuice.task_16;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TrelloCRUDTest {
	private static final String CREATE_BOARD_URL = "https://api.trello.com/1/boards/?name=%s&key=%s&token=%s";
	private static final String GET_BOARD_URL = "https://api.trello.com/1/boards/%s?key=%s&token=%s";
	private static final String BOARD_NAME = "username-co";
	private static final String KEY = "f037495712ba064a957e97dad510b26b";
	private static final String TOKEN = "f02f1be70c984f4535604d200aa9d074e0fa2eb12f1f937a9ed8076d6fd31816";
	private String boardId;

	@BeforeTest
	public void prepare() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	}

	@Test
	public void createBoard() {
		Response response = given().when()
				.contentType("application/json")
				.log().all()
				.post(String.format(CREATE_BOARD_URL, BOARD_NAME, KEY, TOKEN));
		response.then()
				.assertThat()
				.statusCode(200);
		boardId = response.getBody().jsonPath().get("id");
	}

	@Test(dependsOnMethods = "createBoard")
	public void getBoard() {
		given().when()
				.contentType("application/json")
				.log().all()
				.get(String.format(GET_BOARD_URL, boardId, KEY, TOKEN))
				.then()
				.assertThat()
				.statusCode(200);
	}
}
