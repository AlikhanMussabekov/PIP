package ru.cs.ifmo.ligos.db.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.cs.ifmo.ligos.db.entities.AgeCategoryEntity;

public interface AgeCategoryRepository extends CrudRepository<AgeCategoryEntity, Long> {
}