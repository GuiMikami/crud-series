package br.com.senacsp.crudseries.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "serie")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "O título não pode estar em branco")
    private String titulo;
    @NotBlank(message = "O gênero não pode estar em branco")
    private String genero;
    @NotNull(message = "O ano de lançamento não pode ser nulo")
    @Positive(message = "O ano de lançamento deve ser um número positivo")
    private int anoDeLancamento;
}