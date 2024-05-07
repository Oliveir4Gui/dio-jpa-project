package me.dio.academia.entity;

import java.time.LocalDateTime;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tb_matriculas")
@Entity
public class Matricula {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @OneToOne(cascade=CascadeType.ALL)
  @JoinColumn(name = "aluno_id")
  private Aluno aluno;

  private LocalDateTime dataDaMatricula = LocalDateTime.now();
}
