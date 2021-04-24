package net.haaja.jsondumper.repository;

import net.haaja.jsondumper.domain.JsonPayload;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface JsonPayloadRepository extends CrudRepository<JsonPayload, Long> {

}
