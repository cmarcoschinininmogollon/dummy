package pe.com.integracion.dummy.dummyintegration.service;

public interface DatosService {
		
	void lecturaDatos() throws Exception;
	void guardarLogBD(Boolean estadoMensaje, String codigoMensaje);

}
