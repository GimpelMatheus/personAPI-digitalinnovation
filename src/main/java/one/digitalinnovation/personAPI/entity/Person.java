package one.digitalinnovation.personAPI.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) //obrigatório
    private String firstName;

    @Column(nullable = false) //obrigatório
    private String lastName;

    @Column(nullable = false, unique = true) //obrigatório e único
    private String cpf;

    private LocalDate birthDate;

    //cascade é uma estratégia de inserção para fazer direto no cadastro de pessoa
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Phone> phones;
}
