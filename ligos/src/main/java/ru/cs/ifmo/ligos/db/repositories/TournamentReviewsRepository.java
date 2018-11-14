package ru.cs.ifmo.ligos.db.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.cs.ifmo.ligos.db.entities.TournamentReviewsEntity;

public interface TournamentReviewsRepository extends CrudRepository<TournamentReviewsEntity, Long> {
}