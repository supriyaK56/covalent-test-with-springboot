package testcase.model;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
	public interface PersonDao extends CrudRepository<Person,Long> {

	}
