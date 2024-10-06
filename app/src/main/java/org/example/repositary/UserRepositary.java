package org.example.repositary;

import org.example.enities.UserInfo;
import org.example.enities.UserInfoDto;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserRepositary extends CrudRepository <UserInfo,String> {

    Optional<UserInfo> findByUserId(String userId);


}
