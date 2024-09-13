package entities;



import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "prenotazioni")
public class Prenotazione {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

    @ManyToOne
    @JoinColumn(name = "viaggio_id")
    private Viaggio viaggio;

    private LocalDate data;
    private String note;

    public Prenotazione(Dipendente dipendente, Viaggio viaggio, LocalDate data, String note) {
        this.dipendente = dipendente;
        this.viaggio = viaggio;
        this.data = data;
        this.note = note;
    }
}
