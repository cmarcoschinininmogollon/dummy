package pe.com.integracion.dummy.dummyintegration.scheduler;


import lombok.extern.slf4j.Slf4j;
import pe.com.integracion.dummy.dummyintegration.service.DatosService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;


@Configuration
@Slf4j
public class Tasks {

	@Autowired
	private DatosService datosService;

	@Scheduled(cron = "${dummy.cron.lectura}")
	public void lecturaDatos() {

		log.info("[INICIO] - METODO: [lecturaDatos]");

		try {
			datosService.lecturaDatos();			

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		log.info("[FIN] - METODO: [lecturaDatos]");

	}

}
