package com.pablojuice.task_16;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TrelloCRUDRawJavaTest {
	private static final String CREATE_BOARD_URL = "https://api.trello.com/1/boards/?name=%s&key=%s&token=%s";
	private static final String GET_BOARD_URL = "https://api.trello.com/1/boards/%s?key=%s&token=%s";
	private static final String BOARD_NAME = "username-co";
	private static final String KEY = "f037495712ba064a957e97dad510b26b";
	private static final String TOKEN = "f02f1be70c984f4535604d200aa9d074e0fa2eb12f1f937a9ed8076d6fd31816";
	private String boardId;

	@Test
	public void createBoard() throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(String.format(CREATE_BOARD_URL, BOARD_NAME, KEY, TOKEN)))
				.POST(HttpRequest.BodyPublishers.noBody())
				.build();

		HttpResponse<String> response = HttpClient.newBuilder().build().send(request,
																			 HttpResponse.BodyHandlers.ofString());

		Assert.assertEquals(response.statusCode(), 200, "Invalid status code");
		boardId = new JSONObject(response.body()).getString("id");
	}

	@Test(dependsOnMethods = "createBoard")
	public void getBoard() throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(String.format(GET_BOARD_URL, boardId, KEY, TOKEN)))
				.GET()
				.build();

		HttpResponse<String> response = HttpClient.newBuilder().build()
				.send(request, HttpResponse.BodyHandlers.ofString());

		Assert.assertEquals(response.statusCode(), 200, "Invalid status code");
	}
}
