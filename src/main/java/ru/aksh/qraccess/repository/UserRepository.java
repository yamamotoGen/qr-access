package ru.aksh.qraccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aksh.qraccess.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
