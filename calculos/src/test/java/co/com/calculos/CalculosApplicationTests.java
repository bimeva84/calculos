package co.com.calculos;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import javax.script.ScriptException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.calculos.dto.ResponseDto;
import co.com.calculos.enumeraciones.OPERACIONES;
import co.com.calculos.services.CalculoService;
import co.com.calculos.util.Constantes;

@SpringBootTest
class CalculosApplicationTests {
	
	ResponseDto response;

	@Autowired
	CalculoService calculoService;

	@Test
	void contextLoads() {
	}

	@Test
	void testAgregarOperando() {
		response= new ResponseDto();
		
		response = calculoService.agregarOperando(1);
		assertThat(response.getBody()).isEqualTo(Constantes.OK);
	}

	@Test
	void testCalcular() throws ScriptException {
		Integer[] arregloNumeros = { 20, 2, 4, 3, 5 };
		List<Integer> numeros = Arrays.asList(arregloNumeros);
		calculoService.llenarOperandos(numeros);
		response= new ResponseDto();

		// SUMA
		response = calculoService.calcular(OPERACIONES.SUMA.getNombre());
		assertThat(response.getBody()).isEqualTo(33.0);
		// RESTA
		response = calculoService.calcular(OPERACIONES.RESTA.getNombre());
		assertThat(response.getBody()).isEqualTo(7.0);
		// MULTIPLICACION
		response = calculoService.calcular(OPERACIONES.MULTIPLICACION.getNombre());
		assertThat(response.getBody()).isEqualTo(1600.0);
		// DIVISION
		response = calculoService.calcular(OPERACIONES.DIVISION.getNombre());
		assertThat(response.getBody()).isEqualTo(0.25);
		// POTENCIACION
		response = calculoService.calcular(OPERACIONES.POTENCIACION.getNombre());
		assertThat(response.getBody()).isEqualTo(1.2089258196146292E104);
	}

}
