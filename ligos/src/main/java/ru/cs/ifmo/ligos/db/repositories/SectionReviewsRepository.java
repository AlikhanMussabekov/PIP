package ru.cs.ifmo.ligos.db.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.cs.ifmo.ligos.db.entities.SectionReviewsEntity;

public interface SectionReviewsRepository extends CrudRepository<SectionReviewsEntity, Long> {
}