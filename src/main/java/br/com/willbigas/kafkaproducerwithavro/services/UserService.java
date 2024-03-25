package br.com.willbigas.kafkaproducerwithavro.services;

import br.com.willbigas.kafkaproducerwithavro.dtos.UserDTO;
import br.com.willbigas.kafkaproducerwithavro.models.User;
import br.com.willbigas.kafkaproducerwithavro.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final KafkaService kafkaService;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, KafkaService kafkaService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.kafkaService = kafkaService;
    }


    public UserDTO save(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        userRepository.save(user);
        kafkaService.producer(userDTO);
        return userDTO;
    }
}
