package ru.cs.ifmo.ligos.db.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.cs.ifmo.ligos.db.entities.TournamentEntity;

public interface TournamentRepository extends CrudRepository<TournamentEntity, Long> {
}