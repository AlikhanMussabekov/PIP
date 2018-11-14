package ru.cs.ifmo.ligos.db.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.cs.ifmo.ligos.db.entities.MatchesEntity;

public interface MatchesRepository extends CrudRepository<MatchesEntity, Long> {
}