package ru.cs.ifmo.ligos.db.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.cs.ifmo.ligos.db.entities.AddressEntity;

public interface AddressRepository extends CrudRepository<AddressEntity, Long> {
}
