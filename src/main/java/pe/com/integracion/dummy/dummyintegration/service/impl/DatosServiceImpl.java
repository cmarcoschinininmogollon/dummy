package pe.com.integracion.dummy.dummyintegration.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.com.integracion.dummy.dummyintegration.exception.ValidatorFieldsException;
import pe.com.integracion.dummy.dummyintegration.model.LogValuesEntity;
import pe.com.integracion.dummy.dummyintegration.repository.LogValuesRepository;
import pe.com.integracion.dummy.dummyintegration.service.DatosService;
import pe.com.integracion.dummy.dummyintegration.utils.JobLogger;

@Service
@Slf4j
public class DatosServiceImpl implements DatosService {

	@Value("${dummy.ruta_logs}")
	private String rutaLogs;

	@Autowired
	private LogValuesRepository logValuesRepository;

	@SuppressWarnings("unused")
	@Override
	public void lecturaDatos() throws Exception, ValidatorFieldsException {

		String mensajeValidacion = null;
		Map<String, String> dbParams=null;
		List<String> listaNombres = null;
		
		try {

			dbParams = new HashMap<String, String>();
			dbParams.put("logFileFolder", rutaLogs);
			JobLogger jobLogger = new JobLogger(true, true, true, true, true, true, dbParams);
			
			JobLogger.LogMessage("MENSAJE INFORMATIVO - EMPEZANDO CON LA LECTURA DE NOMBRES", true, false, false);
			guardarLogBD(true, String.valueOf(1));
			
			
			int countlistaNombres = (int) Math.floor(Math.random()*6+1);
			int indexNombre = (int) Math.floor(Math.random()*6+1);

			if ((countlistaNombres-1)>0) {

				listaNombres = new ArrayList<String>();
				listaNombres.add("JUAN");
				listaNombres.add("VICTOR");
				listaNombres.add("CRISTHIAN");
				listaNombres.add("ANDRES");
				
				JobLogger.LogMessage("MENSAJE INFORMATIVO - NOMBRE ENCONTRADO :"+listaNombres.get(indexNombre).toString(), true, false, false);
				guardarLogBD(true, String.valueOf(1));
					
			} else {

				mensajeValidacion = "MENSAJE ADVERTENCIA - LISTA DE NOMBRES ES OBLIGATORIO";
				throw new ValidatorFieldsException(mensajeValidacion);
			}

		} catch (ValidatorFieldsException vfe) {

			JobLogger.LogMessage(vfe.getMensajeValidacion(), false, true, false);
			guardarLogBD(false, String.valueOf(3));

		} catch (Exception e) {

			JobLogger.LogMessage("MENSAJE ERROR - "+ e.toString(), false, false, true);
			guardarLogBD(false, String.valueOf(2));

		}
	}

	public void guardarLogBD(Boolean estadoMensaje, String codigoMensaje) {

		LogValuesEntity logValuesEntity = new LogValuesEntity();
		logValuesEntity.setEstadoMensaje(estadoMensaje);
		logValuesEntity.setCodigoMensaje(codigoMensaje);
		logValuesRepository.save(logValuesEntity);

	}


}