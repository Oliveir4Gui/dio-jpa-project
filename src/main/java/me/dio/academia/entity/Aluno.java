package me.dio.academia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tb_alunos")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
public class Aluno {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  @Column(unique = true)
  private String cpf;

  private String bairro;

  private LocalDate dataDeNascimento;
  @JsonManagedReference
  @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonIgnore
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public LocalDate getDataDeNascimento() {
    return dataDeNascimento;
  }

  public void setDataDeNascimento(LocalDate dataDeNascimento) {
    this.dataDeNascimento = dataDeNascimento;
  }

  public List<AvaliacaoFisica> getAvaliacoes() {
      return avaliacoes;
  }

  public void setAvaliacoes(List<AvaliacaoFisica> avaliacoes) {
    this.avaliacoes = avaliacoes;
  }

  public List<AvaliacaoFisica> getAvaliacaoFisicas() {
    return avaliacoes;
  }
}


