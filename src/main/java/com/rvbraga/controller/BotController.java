package com.rvbraga.controller;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rvbraga.models.WhatsAppRequest;

@RestController
@RequestMapping("/webhook")
public class BotController {
	 @PostMapping("/whatsapp")
	    public ResponseEntity<String> receberDados(@RequestBody WhatsAppRequest request) {
	        request.setDataCadastro(LocalDate.now());
		 	System.out.println("📩 Dados recebidos do WhatsApp:");	        
	        System.out.println(request);
	        return ResponseEntity.ok("Dados recebidos com sucesso!");
	    }
}
