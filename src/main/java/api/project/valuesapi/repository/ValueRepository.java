package api.project.valuesapi.repository;

import api.project.valuesapi.entity.Value;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValueRepository extends JpaRepository<Value,Long> {

}
