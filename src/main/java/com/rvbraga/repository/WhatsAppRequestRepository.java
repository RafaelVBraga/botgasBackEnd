package com.rvbraga.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rvbraga.models.WhatsAppRequest;

@Repository
public interface WhatsAppRequestRepository extends JpaRepository<WhatsAppRequest ,UUID>{

	@Query("SELECT w, " +
	           "SUM(CASE WHEN w.tipoGas = 'P13' THEN w.botijoesVazios ELSE 0 END) AS totalVaziosP13, " +
	           "SUM(CASE WHEN w.tipoGas = 'P45' THEN w.botijoesVazios ELSE 0 END) AS totalVaziosP45 " +
	           "FROM WhatsAppRequest w " +
	           "WHERE w.dataCadastro = :dataCadastro " +
	           "GROUP BY w")
	    List<Object[]> buscarRequisicoesComSomatorio(@Param("dataCadastro") LocalDate dataCadastro);

}