package com.mmn.reservation.repository;

import com.mmn.reservation.model.entity.PassportUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportUserRepository extends JpaRepository<PassportUser, String> {
}
