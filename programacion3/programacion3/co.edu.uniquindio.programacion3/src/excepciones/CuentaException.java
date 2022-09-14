package excepciones;

public class CuentaException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensajeUnificado = "";

	public CuentaException(String mensaje) {
		super(mensaje);
	}
}
