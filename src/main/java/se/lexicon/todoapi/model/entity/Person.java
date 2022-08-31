package se.lexicon.todoapi.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer personId;
    private String firstname;
    private String lastname;
    private LocalDate birthDate;
    @OneToOne
    @JoinColumn(name = "username")
    private User user;

}
