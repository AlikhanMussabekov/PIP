package ru.cs.ifmo.ligos.db.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.cs.ifmo.ligos.db.entities.TournamentTeamsEntity;

public interface TournamentTeamsRepository extends CrudRepository<TournamentTeamsEntity, Long> {
}