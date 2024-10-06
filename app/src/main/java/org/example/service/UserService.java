package org.example.service;

import org.example.enities.UserInfo;
import org.example.enities.UserInfoDto;
import org.example.repositary.UserRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@Service
public class UserService {

    @Autowired
    private UserRepositary userRepositary;

    public UserInfoDto createOrUpdateUser(UserInfoDto userInfoDto){
        UnaryOperator<UserInfo> updatingUser = user -> {
            return userRepositary.save(userInfoDto.transformToUserInfo());
        };

        Supplier<UserInfo> createUser = () -> {
            return userRepositary.save(userInfoDto.transformToUserInfo());
        };

        UserInfo userInfo = userRepositary.findByUserId(userInfoDto.getUserId())
                .map(updatingUser)
                .orElseGet(createUser);
        return new UserInfoDto(
                userInfo.getUserId(),
                userInfo.getFirstName(),
                userInfo.getLastName(),
                userInfo.getPhoneNumber(),
                userInfo.getEmail(),
                userInfo.getProfilePic()
        );

    }

    public UserInfoDto getUser(UserInfoDto userInfoDto) throws Exception{
        Optional<UserInfo> userInfoDtoOpt = userRepositary.findByUserId(userInfoDto.getUserId());
        if(userInfoDtoOpt.isEmpty()){
            throw new Exception("User not found");
        }
        UserInfo userInfo = userInfoDtoOpt.get();
        return new UserInfoDto(
                userInfo.getUserId(),
                userInfo.getFirstName(),
                userInfo.getLastName(),
                userInfo.getPhoneNumber(),
                userInfo.getEmail(),
                userInfo.getProfilePic()
        );
    }


}
