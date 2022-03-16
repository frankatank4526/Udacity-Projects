package com.udacity.pricing;

import com.udacity.pricing.domain.price.Price;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PricingServiceApplicationTests {
	@LocalServerPort
	private int port;

	@Autowired
	TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testPricingService(){
		ResponseEntity<Price> response =
		this.restTemplate.getForEntity("http://localhost:" + port + "/services/price?vehicleId=1", Price.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}
}
