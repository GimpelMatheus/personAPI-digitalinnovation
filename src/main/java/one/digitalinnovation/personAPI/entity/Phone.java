package one.digitalinnovation.personAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personAPI.enums.PhoneType;

import javax.persistence.*;

@Entity
//Pra não ter que ficar gerando todos getters e setters
//vamos usar o lombok, o @Data tem
@Data// vem com getter e setter
@Builder//padrão de projetos
@AllArgsConstructor//insere os construtores
@NoArgsConstructor
public class Phone {
    //JPA PARA FAZER MAPEAMENTO E CRIAR MODELOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false) //obrigatório
    private PhoneType type;

    @Column(nullable = false) //obrigatório
    private String number;
}
