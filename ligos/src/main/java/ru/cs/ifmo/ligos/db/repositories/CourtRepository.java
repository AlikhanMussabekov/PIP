package ru.cs.ifmo.ligos.db.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.cs.ifmo.ligos.db.entities.CourtEntity;

public interface CourtRepository extends CrudRepository<CourtEntity, Long> {
}