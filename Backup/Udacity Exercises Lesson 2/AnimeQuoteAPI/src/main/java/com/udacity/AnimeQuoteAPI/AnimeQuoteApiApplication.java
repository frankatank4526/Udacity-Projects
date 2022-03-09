package com.udacity.AnimeQuoteAPI;

import com.udacity.AnimeQuoteAPI.entity.AnimeQuote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Locale;

@SpringBootApplication
public class AnimeQuoteApiApplication {

	private static final Logger log = LoggerFactory.getLogger(AnimeQuoteApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AnimeQuoteApiApplication.class, args);
	}


	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
		return args -> {
			AnimeQuote animeQuote = restTemplate.getForObject(
					"https://animechan.vercel.app/api/random", AnimeQuote.class);
			log.info(animeQuote.toString());
		};

	}
}
