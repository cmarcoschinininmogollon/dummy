package pe.com.integracion.dummy.dummyintegration;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@Slf4j
public class DummyIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(DummyIntegrationApplication.class, args);
    }

}
