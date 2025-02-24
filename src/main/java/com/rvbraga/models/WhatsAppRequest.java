package com.rvbraga.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity@Data
public class WhatsAppRequest implements  Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String nome;
    private String cargo;
    private String escola;
    private String rota;
    private String tipoGas;
    private Integer botijoesCheios;
    private Integer botijoesVazios;
    private LocalDate dataCadastro;
	
	

}
