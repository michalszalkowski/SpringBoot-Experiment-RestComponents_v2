package pl.btbw.core.util;

public class Link {

	public String method = "GET";
	public String url;

	public Link(String url) {
		this.url = url;
	}

	public Link(String method, String url) {
		this.method = method;
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public String getMethod() {
		return method;
	}
}
