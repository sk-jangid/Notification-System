package com.Amazon.services.sendMessage;

import java.net.URI;

// Configurations of the API end Point
public interface APIConfiguration {
	 public static final URI API_BASE_URL = URI.create("https://api.line.me/");
	// public static final URI API_BASE_URL = URI.create("https://hookb.in/");

	 public static final long CONNECT_TIMEOUT_MILLIS = 3_000;
	 public static final long READ_TIMEOUT_MILLIS = 3_000;
	 public static final long WRITE_TIMEOUT_MILLIS = 3_000;
}
