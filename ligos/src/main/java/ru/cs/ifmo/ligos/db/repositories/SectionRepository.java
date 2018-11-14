package ru.cs.ifmo.ligos.db.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.cs.ifmo.ligos.db.entities.SectionEntity;

public interface SectionRepository extends CrudRepository<SectionEntity, Long> {
}