package br.dev.phsaraiva.alafiasaude.data.dto;

import br.dev.phsaraiva.alafiasaude.model.Prontuario;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

public class PacienteDTO extends RepresentationModel<PacienteDTO> implements Serializable {

        private static final long serialVersionUID = 1L;

        private Long id;
        private String nome;
        private String cpf;
        private String email;
        private String telefone;
        private Prontuario prontuario;

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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public Prontuario getProntuario() {
            return prontuario;
        }

        public void setProntuario(Prontuario prontuario) {
            this.prontuario = prontuario;
        }
    }


