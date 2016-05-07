package oleg.diplom.entity;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by user1 on 07.04.2016.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long>, JpaSpecificationExecutor {
    Customer findById(Long id);
}
