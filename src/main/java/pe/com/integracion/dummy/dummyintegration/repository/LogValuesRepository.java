package pe.com.integracion.dummy.dummyintegration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.integracion.dummy.dummyintegration.model.LogValuesEntity;



@Repository
public interface LogValuesRepository extends JpaRepository<LogValuesEntity, Long>  {
	

}

