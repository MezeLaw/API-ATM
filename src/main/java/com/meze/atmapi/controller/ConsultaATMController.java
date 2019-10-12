package com.meze.atmapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.meze.atmapi.dto.CajeroAutomatico;
import com.meze.atmapi.wrapper.CajeroAutomaticoList;

@Controller
public class ConsultaATMController {

	@GetMapping(path = "/obtenerAtms")
	public void obtenerCajeros() {

		try {
			
//			/** De esta forma no puede deserializar...  Agregue la dependencia de jackson pero no funca igual xd **/
//			RestTemplate restTemplate = new RestTemplate();
//			CajeroAutomaticoList response = restTemplate.getForObject(
//					"https://api-2445582796097.staging.gw.apicast.io/api/v1/atms?apikey=68b1e175f2fdfcbfddf461bcc9991d5b",
//					CajeroAutomaticoList.class);
//			List<CajeroAutomatico> cajeros = response.getCajerosAutomaticos();
			
			/** De esta forma pareciera que jamas llega info pero la lista de objetos es armada correctamente **/
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<List<CajeroAutomatico>> response = restTemplate.exchange(
			  "https://api-2445582796097.staging.gw.apicast.io/api/v1/atms?apikey=68b1e175f2fdfcbfddf461bcc9991d5b",
			  HttpMethod.GET,
			  null,
			  new ParameterizedTypeReference<List<CajeroAutomatico>>(){});
			List<CajeroAutomatico> cajeros = response.getBody();

			for (CajeroAutomatico atm : cajeros) {
				System.out.println(atm.getName() + ":" + atm.getAmount_Left() + "efectivo disponible. ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Este es un metodo con un id harcodeado pero que existe. Solo para probar si me los trae null igual xd
	@GetMapping(path = "/obtenerAtmPorId")
	public void obtenerCajeroPorId() {
   
		try {
			
			RestTemplate restTemplate = new RestTemplate();
			CajeroAutomatico response = restTemplate.getForObject(
			  "https://api-2445582796097.staging.gw.apicast.io/api/v1/atms/S1AGL273D?apikey=68b1e175f2fdfcbfddf461bcc9991d5b",
			  CajeroAutomatico.class);

			System.out.println(response.getName()+": "+response.getAmount_Left() +"disponible para extracciones.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
