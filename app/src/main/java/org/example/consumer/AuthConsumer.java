package org.example.consumer;

import org.example.repositary.UserRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AuthConsumer {

        private UserRepositary userRepositary;

        @Autowired
        AuthConsumer(UserRepositary userRepositary){
                this.userRepositary=userRepositary;
        }

        @KafkaListener(topics = "${spring.kafka.topic-json.name}",groupId = "${spring.kafka.consumer.group-id}")
        public  void listen(Object evenData){
                try{

                } catch (Exception e) {
                        throw new RuntimeException(e);
                }
        }
        


}
