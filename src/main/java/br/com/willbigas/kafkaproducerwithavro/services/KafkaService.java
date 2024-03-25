package br.com.willbigas.kafkaproducerwithavro.services;

import br.com.willbigas.avro.UserAvro;
import br.com.willbigas.kafkaproducerwithavro.dtos.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaService {

    @Value("${topic.name.producer}")
    private String value;

    private final KafkaTemplate<String, UserAvro> kafkaTemplate;

    public KafkaService(KafkaTemplate<String, UserAvro> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void producer(UserDTO userDTO) {
        UserAvro userAvro = UserAvro.newBuilder().setName(userDTO.getName())
                .setAge(userDTO.getAge())
                .setDocumentNumber(userDTO.getDocumentNumber())
                .setPhone(userDTO.getPhone())
                .build();
        kafkaTemplate.send(value, userAvro);
        log.info("{}",userAvro);
    }
}
