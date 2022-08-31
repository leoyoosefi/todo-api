package se.lexicon.todoapi.model.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonDto {

    private Integer personId;
    @NotEmpty
    @Size(min = 2, max = 100)
    private String firstname;
    @NotEmpty
    @Size(min = 2, max = 100)
    private String lastname;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull
    private LocalDate birthdate;

}
