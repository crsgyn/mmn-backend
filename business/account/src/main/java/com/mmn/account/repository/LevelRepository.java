package com.mmn.account.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmn.account.model.entity.Level;

public interface LevelRepository extends JpaRepository<Level, UUID> {
	Optional<Level> findByChildId(String accountId);

	List<Level> findByParentId(String accountId);
}
