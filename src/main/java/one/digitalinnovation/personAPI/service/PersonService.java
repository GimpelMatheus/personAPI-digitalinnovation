package one.digitalinnovation.personAPI.service;

import one.digitalinnovation.personAPI.dto.MessageResponseDTO;
import one.digitalinnovation.personAPI.entity.Person;
import one.digitalinnovation.personAPI.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//classe para regras de negócio
@Service
public class PersonService {

    private PersonRepository personRepository;

    //injeção de dependências e inversão de controle
    @Autowired //Spring injeta uma implementação aqui pra dentro, somente este contrato
    public PersonService(PersonRepository personRepository) {
        //facilita para criar testes unitários
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person){
        Person savedPerson = personRepository.save(person); //RequestBody fala que ta vindo por uma requisição
        return MessageResponseDTO.
                builder()
                .message("Created Person with ID " + savedPerson.getId())
                .build();
    }
}
