package com.cherry.user.mapper;


import com.cherry.user.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import  com.cherry.user.entity.User;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapUserDtoToUser(UserDto userDto);

    UserDto mapUserToUserDto(User user);


}
