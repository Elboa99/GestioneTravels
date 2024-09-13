package entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "viaggio")
public class Viaggio {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID uuid;
    private String destinazione;
    private LocalDate data;
    private String stato;


    public Viaggio(String destinazione, LocalDate data, String stato) {
        this.destinazione = destinazione;
        this.data = data;
        this.stato = stato;
    }
}

