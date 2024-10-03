package org.example.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;
import org.example.enities.UserInfoDto;
import java.nio.ByteBuffer;
import java.util.Map;

public class UserInfoDeserializer implements Deserializer<UserInfoDto> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public UserInfoDto deserialize(String arg0, byte[] args1) {
        ObjectMapper objectMapper=new ObjectMapper();
        UserInfoDto userInfoDto=null;
        try{
         userInfoDto=   objectMapper.readValue(args1,UserInfoDto.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return userInfoDto;
    }

    @Override
    public UserInfoDto deserialize(String topic, Headers headers, byte[] data) {
        return Deserializer.super.deserialize(topic, headers, data);
    }

    @Override
    public UserInfoDto deserialize(String topic, Headers headers, ByteBuffer data) {
        return Deserializer.super.deserialize(topic, headers, data);
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
