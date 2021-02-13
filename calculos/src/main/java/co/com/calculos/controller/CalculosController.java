package co.com.calculos.controller;

import javax.script.ScriptException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.calculos.dto.ResponseDto;
import co.com.calculos.services.CalculoService;

@RestController
@RequestMapping(value = "/calculos")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class CalculosController {
	
	@Autowired
	CalculoService calculoService;
	
	@PostMapping(value = "/agregarOperando",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto> agregarOperando(@RequestBody Integer operando) {
		ResponseDto response = calculoService.agregarOperando(operando);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(value = "/calcular",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto> calcular(@RequestBody String operador) throws ScriptException {
		ResponseDto response = calculoService.calcular(operador);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
