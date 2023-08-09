package com.hyunseung.webETA.repository;

import com.hyunseung.webETA.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
