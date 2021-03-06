package net.flower.ixmsxms.service.domain;

import javax.servlet.http.HttpServletRequest;

public class ThreadLocalObject {
	public static ThreadLocal<ThreadLocalObject> local = new ThreadLocal<ThreadLocalObject>();
	
	private HttpServletRequest request;

	public HttpServletRequest getRequest() {
		return request;
	}

	public ThreadLocalObject setRequest(HttpServletRequest request) {
		this.request = request;
		return this;
	}
}
