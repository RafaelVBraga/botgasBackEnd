package com.rvbraga.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rvbraga.models.WhatsAppRequest;
import com.rvbraga.service.WarService;

@RestController
@RequestMapping("/webhook")
public class BotController {
	@Autowired
	private WarService warService;
	
	 @PostMapping("/whatsapp")
	    public ResponseEntity<String> receberDados(@RequestBody WhatsAppRequest request) {
	        request.setDataCadastro(LocalDate.now());
		 	System.out.println(" 📩 Dados recebidos do WhatsApp:");	        
	        warService.save(request);
	        return ResponseEntity.ok("📩 Dados recebidos com sucesso!");
	    }
}
