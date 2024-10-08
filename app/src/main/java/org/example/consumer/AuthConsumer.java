package org.example.consumer;

import org.example.enities.UserInfo;
import org.example.enities.UserInfoDto;
import org.example.repositary.UserRepositary;
import org.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AuthConsumer {

        private static final Logger logger = LoggerFactory.getLogger(AuthConsumer.class);

        @Autowired
        private UserService userService;

        @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
        public void listen(UserInfoDto eventData) {
                try {
                        // Log received data for debugging
                        logger.info("Received Kafka message: {}", eventData);



                        userService.createOrUpdateUser(eventData);


                } catch(Exception ex){
                        ex.printStackTrace();
                        System.out.println("AuthServiceConsumer: Exception is thrown while consuming kafka event");
                }
        }
}
