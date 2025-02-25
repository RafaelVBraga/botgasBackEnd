package com.rvbraga.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rvbraga.service.WarService;

@Controller
public class ViewController {
	@Autowired
	private WarService warService;
	
	@GetMapping("/relatorio")
	public String relatorio(Model model) {
		model.addAttribute("dados",warService.buscarRequisicoes(LocalDate.now()));
		return "relatorio.html";
	}
}
