package org.example.repositary;

import org.example.enities.UserInfoDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositary extends CrudRepository <UserInfoDto,String> {



}
