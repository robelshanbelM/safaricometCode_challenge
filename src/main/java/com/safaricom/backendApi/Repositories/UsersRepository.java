package com.safaricom.backendApi.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.safaricom.backendApi.Entitys.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

	
	Optional<Users> findByLogin(String login);

}
