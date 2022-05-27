package com.pablojuice.task_17;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class TrelloTest {

	@Test
	public void createBoard() throws Exception {
		Request createBoardRequest = RequestRepository.buildCreateBoardRequest(UUID.randomUUID().toString());
		Response response = Client.execute(createBoardRequest);
		Assert.assertEquals(response.getStatusCode(), 200, "Invalid status code");
	}
}
