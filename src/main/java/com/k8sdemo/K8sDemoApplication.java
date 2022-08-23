package com.k8sdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@RestController
public class K8sDemoApplication {
	private static String LINE_SEPARATOR_HTML = "<br>";
	@Value("${config.map}")
	private String configMap;

	@Value("${secret}")
	private String secret;

	public static void main(String[] args) {
		SpringApplication.run(K8sDemoApplication.class, args);
	}

	@GetMapping("")
	public String getConfigMapAndSecret(HttpServletRequest request) throws UnknownHostException {
		String hostName = InetAddress.getLocalHost().getHostName();

		StringBuilder responseMessage = new StringBuilder();
		responseMessage.append("The request is consumed by: ");
		responseMessage.append(hostName);
		responseMessage.append(LINE_SEPARATOR_HTML);
		responseMessage.append(LINE_SEPARATOR_HTML);
		responseMessage.append("The value get from Config Map: ");
		responseMessage.append(configMap);
		responseMessage.append(LINE_SEPARATOR_HTML);
		responseMessage.append(LINE_SEPARATOR_HTML);
		responseMessage.append("The value get from Secret: ");
		responseMessage.append(secret);

		return responseMessage.toString();
	}
}
