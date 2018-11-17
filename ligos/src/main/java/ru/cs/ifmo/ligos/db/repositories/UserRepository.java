package ru.cs.ifmo.ligos.db.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.cs.ifmo.ligos.db.entities.UserEntity;
import ru.cs.ifmo.ligos.db.entities.TeamEntity;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

	UserEntity findByEmail(String email);

	/*@Query("select name from TEAM where ")
	public List<UserEntity> findUserTeams(@Param("userId") Long id);*/

}