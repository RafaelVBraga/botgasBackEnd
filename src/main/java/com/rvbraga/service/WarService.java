package com.rvbraga.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvbraga.models.WhatsAppRequest;
import com.rvbraga.repository.WhatsAppRequestRepository;

@Service
public class WarService {
	
	@Autowired
	private WhatsAppRequestRepository wRepo;
	
	public WhatsAppRequest save(WhatsAppRequest war) {
		return wRepo.save(war);
	}
	
	public Map<String, Object> buscarRequisicoes(LocalDate dataCadastro) {
        List<Object[]> resultados = wRepo.buscarRequisicoesComSomatorio(dataCadastro);

        Map<String, Object> resposta = new HashMap<>();
        resposta.put("requisicoes", resultados);
        resposta.put("totalVaziosP13", resultados.stream().mapToInt(r -> ((Number) r[1]).intValue()).sum());
        resposta.put("totalVaziosP45", resultados.stream().mapToInt(r -> ((Number) r[2]).intValue()).sum());

        return resposta;
    }
}
