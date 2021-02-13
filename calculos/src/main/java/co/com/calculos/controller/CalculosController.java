package co.com.calculos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/calculos")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class CalculosController {
	@PostMapping(value = "/agregarOperando",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> agregarOperando() {
		String response = "Ok";
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
