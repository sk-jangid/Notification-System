package com.Amazon.services.clients.LINEClient;

import java.net.URI;

// Configurations of the API end Point
public interface APIConfiguration {
	 public static final URI API_BASE_URL = URI.create("https://api.line.me/");
	 public static String CHANNEL_ACCESS_TOKEN="Your channel access token";
	 public static final long CONNECT_TIMEOUT_MILLIS = 10_000;
	 public static final long READ_TIMEOUT_MILLIS = 10_000;
	 public static final long WRITE_TIMEOUT_MILLIS = 10_000;
}
