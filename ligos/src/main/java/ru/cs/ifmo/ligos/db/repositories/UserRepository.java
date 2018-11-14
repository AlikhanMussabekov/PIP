package ru.cs.ifmo.ligos.db.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.cs.ifmo.ligos.db.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}