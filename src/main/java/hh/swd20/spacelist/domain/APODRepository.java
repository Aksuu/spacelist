package hh.swd20.spacelist.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

	public interface APODRepository extends CrudRepository<APOD, Long> {
		
		List<APOD> findByTitle(String title);

	}
