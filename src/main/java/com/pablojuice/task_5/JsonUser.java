package com.pablojuice.task_5;

public class JsonUser extends JSONModel<JsonUser>{
	public String username;
	public String password;
	public int followers;

	public JsonUser() {

	}

	public JsonUser(String username, String password, Integer followers) {
		this.username = username;
		this.password = password;
		this.followers = followers;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getFollowers() {
		return followers;
	}

	public void setFollowers(Integer followers) {
		this.followers = followers;
	}

	@Override
	public String toString() {
		return "JsonUser{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				", followers=" + followers +
				'}';
	}
}
