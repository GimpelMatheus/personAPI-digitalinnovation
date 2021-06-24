package one.digitalinnovation.personAPI.service;

import one.digitalinnovation.personAPI.dto.MessageResponseDTO;
import one.digitalinnovation.personAPI.dto.request.PersonDTO;
import one.digitalinnovation.personAPI.entity.Person;
import one.digitalinnovation.personAPI.exception.PersonNotFoundException;
import one.digitalinnovation.personAPI.mapper.PersonMapper;
import one.digitalinnovation.personAPI.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//classe para regras de negócio
@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;
        //cte da classe criada por nós

    //injeção de dependências e inversão de controle
    @Autowired //Spring injeta uma implementação aqui pra dentro, somente este contrato
    public PersonService(PersonRepository personRepository) {
        //facilita para criar testes unitários
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){

        Person personToSave  = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave); //RequestBody fala que ta vindo por uma requisição
        return MessageResponseDTO.
                builder()
                .message("Created Person with ID " + savedPerson.getId())
                .build();
    }


    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream().map(
                personMapper::toDTO
        ).collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        //Optinal evita verificações como estar nulo

        return personMapper.toDTO(person);
    }
}
