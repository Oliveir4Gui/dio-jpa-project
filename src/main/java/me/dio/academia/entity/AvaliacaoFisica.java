package me.dio.academia.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tb_avaliacoes")

@Entity
public class AvaliacaoFisica {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
 @JsonManagedReference
 @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
 @JoinColumn(name = "aluno_id")
  private Aluno aluno;

  private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

  @Column(name = "peso_atual")
  private double peso;

  @Column(name = "altura_atual")
  private double altura;

}
