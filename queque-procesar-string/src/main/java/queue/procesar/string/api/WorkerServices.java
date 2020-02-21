package queue.procesar.string.api;

import org.springframework.http.ResponseEntity;

public interface WorkerServices {

	public ResponseEntity crearClaveValor();

	public ResponseEntity pasarAMayus();

	public ResponseEntity concatenar();

	public ResponseEntity borrarLetra();

}
