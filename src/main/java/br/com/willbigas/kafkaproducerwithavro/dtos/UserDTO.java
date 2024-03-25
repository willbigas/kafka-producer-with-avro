package br.com.willbigas.kafkaproducerwithavro.dtos;

import lombok.Data;

@Data
public class UserDTO {

	private String name;
	private String documentNumber;
	private Short age;
	private String phone;
}
