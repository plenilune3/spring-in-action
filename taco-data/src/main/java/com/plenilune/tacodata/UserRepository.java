package com.plenilune.tacodata;

import com.plenilune.tacodomain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
