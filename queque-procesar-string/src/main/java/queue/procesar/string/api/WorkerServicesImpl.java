package queue.procesar.string.api;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import worker.model.test.AgregarValorResponse;

public class WorkerServicesImpl implements WorkerServices {

	@Override
	public ResponseEntity crearClaveValor() {
		RestTemplate httpCliente = new RestTemplate();
		ResponseEntity<AgregarValorResponse>response;
		httpCliente.exchange("localhost:8080", HttpMethod.GET, AgregarValorResponse.class, response);
		return null;
	}

	@Override
	public ResponseEntity pasarAMayus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity concatenar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity borrarLetra() {
		// TODO Auto-generated method stub
		return null;
	}

}
