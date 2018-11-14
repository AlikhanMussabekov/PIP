package ru.cs.ifmo.ligos.db.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.cs.ifmo.ligos.db.entities.TournamentDetailsEntity;

public interface TournamentDetailsRepository extends CrudRepository<TournamentDetailsEntity, Long> {
}