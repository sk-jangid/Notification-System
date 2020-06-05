package com.Amazon.services.sendMessage;

import java.net.URI;

// Configurations of the API end Point
public interface APIConfiguration {
	 public static final URI API_BASE_URL = URI.create("https://api.line.me/");
	 public static String CHANNEL_ACCESS_TOKEN="MEGhysNQpGvlM3aMs+g9FaQJcOA0oDD2zKxbUU6O933/QTqiB0zBITtUyjjVHSDY42CD76e/0BjibGyZR5iYZynmbcX042lQqy7eP2YApioEFfTExQypkuGECIZ4ayba54Y9PaTrCOIvRbvixAdeoQdB04t89/1O/w1cDnyilFU=";
	 public static final long CONNECT_TIMEOUT_MILLIS = 10_000;
	 public static final long READ_TIMEOUT_MILLIS = 10_000;
	 public static final long WRITE_TIMEOUT_MILLIS = 10_000;
}
