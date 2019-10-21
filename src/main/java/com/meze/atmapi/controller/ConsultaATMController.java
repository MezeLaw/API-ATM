package com.meze.atmapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.meze.atmapi.dto.CajeroAutomatico;
import com.meze.atmapi.dto.FiltroBusqueda;

@Controller
public class ConsultaATMController {

	private final static Logger logger = Logger.getLogger(ConsultaATMController.class.getName());

	@GetMapping(path = "/obtenerAtms")
	public void obtenerCajeros() {

		try {

			logger.info("ConsultaATMController: Se procede a realizar la busqueda de los ATM disponibles.");

			/**
			 * De esta forma no puede deserializar... Agregue la dependencia de jackson pero
			 * no funca igual xd . Ver a futuro si se puede hacer de esta forma porque es
			 * mas prolija
			 **/

//			RestTemplate restTemplate = new RestTemplate();
//			CajeroAutomaticoList response = restTemplate.getForObject(
//					"https://api-2445582796097.staging.gw.apicast.io/api/v1/atms?apikey=68b1e175f2fdfcbfddf461bcc9991d5b",
//					CajeroAutomaticoList.class);
//			List<CajeroAutomatico> cajeros = response.getCajerosAutomaticos();

			/**
			 * De esta forma pareciera que jamas llega info pero la lista de objetos es
			 * armada correctamente
			 **/
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<List<CajeroAutomatico>> response = restTemplate.exchange(
					"https://api-2445582796097.staging.gw.apicast.io/api/v1/atms?apikey=68b1e175f2fdfcbfddf461bcc9991d5b",
					HttpMethod.GET, null, new ParameterizedTypeReference<List<CajeroAutomatico>>() {
					});
			List<CajeroAutomatico> cajeros = response.getBody();

			for (CajeroAutomatico atm : cajeros) {
				System.out.println(cajeros.indexOf(atm) + 1 + " - " + atm.getId() + " " + atm.getNombre()
						+ " - Efectivo disponible $" + atm.getMontoDisponible() + " - " + atm.getProvincia() + " - "
						+ atm.getCiudad() + " - " + atm.getDireccionCalle() + " " + atm.getDireccionNumero());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo con un id harcodeado en la url, solo para probar
	 */
	@GetMapping(path = "/obtenerAtmPorId/12251993")
	public void obtenerCajeroPorId() {

		try {

			RestTemplate restTemplate = new RestTemplate();
			CajeroAutomatico atm = restTemplate.getForObject(
					"https://api-2445582796097.staging.gw.apicast.io/api/v1/atms/S1AGL273D?apikey=68b1e175f2fdfcbfddf461bcc9991d5b",
					CajeroAutomatico.class);

			System.out.println(atm.getId() + " " + atm.getNombre() + " - Efectivo disponible $"
					+ atm.getMontoDisponible() + " " + atm.getProvincia() + " " + atm.getCiudad() + " - "
					+ atm.getDireccionCalle() + " " + atm.getDireccionNumero());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Realizar busqueda de acuerdo a los parametros ingresados
	 */

	@GetMapping(path = "/buscarATM")
	public @ResponseBody ArrayList<CajeroAutomatico> realizarConsulta(@RequestBody FiltroBusqueda busqueda) {

		ArrayList<CajeroAutomatico> cajerosCalificables = new ArrayList<CajeroAutomatico>();

		try {

			/**
			 * Recupero la informacion en tiempo real. A futuro se puede conectar a una db,
			 * ya esta instalada en el pom, pero entiendo que ahora no vale la pena agrupar
			 * datos ya que dudo se quiera escribir las actualizaciones en una base si esta
			 * el API.
			 */

			logger.info("Se procede a realizar la busqueda de los ATM disponibles.");

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<List<CajeroAutomatico>> response = restTemplate.exchange(
					"https://api-2445582796097.staging.gw.apicast.io/api/v1/atms?apikey=68b1e175f2fdfcbfddf461bcc9991d5b",
					HttpMethod.GET, null, new ParameterizedTypeReference<List<CajeroAutomatico>>() {
					});
			List<CajeroAutomatico> cajeros = response.getBody();

			logger.info("Se procede a quedarme con los resultados que matcheen "
					+ "con la busqueda ingresada por el usuario.");

			/**
			 * Vale aclarar que habria que determinar una ecuacion que nos indique la
			 * probabilidad de disponibilidad de efectivo en funcion de las consultas, no
			 * solo del estado real del ATM. Ademas, tambien habria que manejar bien los CP.
			 * 
			 * Tambien, el significado de accesibilidad..
			 * 
			 */

			for (CajeroAutomatico atm : cajeros) {
				if ((atm.getMontoDisponible() >= busqueda.getExtraccionDeseada() || busqueda.getExtraccionDeseada() > 0)
						&& atm.getProvincia().equals(busqueda.getProvincia())
						&& atm.getCiudad().equals(busqueda.getCiudad())) {

					cajerosCalificables.add(atm);

					System.out.println(atm.getId() + " " + atm.getNombre() + " - Efectivo disponible $"
							+ atm.getMontoDisponible() + " " + atm.getProvincia() + " " + atm.getCiudad() + " - "
							+ atm.getDireccionCalle() + " " + atm.getDireccionNumero());

				}
			}

			if (cajerosCalificables.isEmpty()) {
				logger.info("No se encontraron cajeros disponibles para la busqueda ingresada.");
			} else {
				logger.info("Se encontraron " + cajerosCalificables.size() + " cajeros automaticos "
						+ "que pueden satisfacer el requerimiento del usuario.");
			}

		} catch (Exception e) {
			logger.info("Ocurrio un error al intentar realizar la operación. ConsultaATMController>realizarConsulta");
			e.printStackTrace();
		}

		return cajerosCalificables;
	}

}
