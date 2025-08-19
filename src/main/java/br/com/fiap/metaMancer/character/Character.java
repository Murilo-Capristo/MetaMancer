package br.com.fiap.metaMancer.character;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Character {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank( message = "{character.name.notblank}")
    @Size(min = 3, max = 40, message = "{character.name.size}")
    private String name;

    @NotNull( message = "{character.species.notnull}")
    @Enumerated(EnumType.STRING)
    private Species species;

    @NotNull(message = "{character.startingLevel.notnull}")
    @Min(0) @Max(100)
    private int startingLevel;

    @NotBlank(message = "{character.specialAbility.notblank}")
    @Size(min = 3, max = 60)
    private String specialAbility;

    @Size(min = 0, max = 280, message = "{character.bio.size}")
    private String bio;

    @NotNull(message = "{character.creationDate.notnull}")
    @Past(message = "{character.creationDate.past}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;
}
