package se.lexicon.todoapi.model.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TodoItemDto {

    private Integer todoId;
    @NotEmpty
    @Size(min = 2, max = 50)
    private String title;
    @NotEmpty
    @Size(min = 15, max = 1000)
    private String description;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull
    private LocalDate deadline;
}
