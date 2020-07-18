package com.example.RatingSystem.response;

public class BaseObjectResponse<T> extends AbstractResponse {

	private T data;

	public BaseObjectResponse(T data) {
		super();
		this.data = data;
	}

	public BaseObjectResponse(Integer code, String message, T data) {
		super(code, message);
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public BaseObjectResponse<T> setData(T data) {
		this.data = data;
		return this;
	}
}