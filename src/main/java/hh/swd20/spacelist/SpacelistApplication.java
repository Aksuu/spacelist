package hh.swd20.spacelist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import hh.swd20.spacelist.domain.APOD;
import hh.swd20.spacelist.domain.Item;
import hh.swd20.spacelist.domain.ItemRepository;

@SpringBootApplication
public class SpacelistApplication {
		private static final Logger log = LoggerFactory.getLogger(SpacelistApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpacelistApplication.class, args);
		
		RestTemplate restTemplate = new RestTemplate();
	    APOD apod = restTemplate.getForObject("https://api.nasa.gov/planetary/apod?api_key=eouaU2byphnbSBMhS5Wh8CtwEt7QoDrA67CZOYou", APOD.class);
	    log.info(apod.toString());
	}
	
	@Bean 
	public CommandLineRunner ItemsDemo(ItemRepository itemrepository) {
		return (args) -> {
			log.info("Some items");
			
			itemrepository.save(new Item("First header", "First Description"));
			
			log.info("Fetch all items");
			for (Item item : itemrepository.findAll()) {
				log.info(item.toString());
			}
		};
	}
}
