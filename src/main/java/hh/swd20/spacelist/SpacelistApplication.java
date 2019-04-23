package hh.swd20.spacelist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.spacelist.domain.Item;
import hh.swd20.spacelist.domain.ItemRepository;

@SpringBootApplication
public class SpacelistApplication {
		private static final Logger log = LoggerFactory.getLogger(SpacelistApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpacelistApplication.class, args);
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
