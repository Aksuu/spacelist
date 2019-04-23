package hh.swd20.spacelist.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
	
	List<Item> findByHeader(String header);

}
