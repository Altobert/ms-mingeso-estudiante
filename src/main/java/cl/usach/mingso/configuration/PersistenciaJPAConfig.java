package cl.usach.mingso.configuration;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaRepositories(
    basePackages = "cl.usach.mingeso.repository"//
  , entityManagerFactoryRef = "eolEntityManager"//
  , transactionManagerRef = "eolTransactionManager" 
)
@EnableTransactionManagement
/**
* @descripcion: archivo que maneja la persistencia.
* @author: alberto san martin
*/
public class PersistenciaJPAConfig {

  @Autowired
  private Environment env;

  @Bean("eolDatasourceProperties")
  @Primary
  @ConfigurationProperties("spring.datasource-mingeso")        
  public DataSourceProperties eolDatasourceProperties(){
      return new DataSourceProperties();
  }

  @Bean("eolDataSource")
  @Primary   
  @ConfigurationProperties("spring.datasource-mingeso")
  public DataSource eolDataSource(@Qualifier("eolDatasourceProperties") DataSourceProperties eolDatasourceProperties){
      DataSource dataSource = eolDatasourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
      return dataSource;
  }
  
  @Bean("eolJdbcTemplate")
  @Primary
  public JdbcTemplate eolJdbcTemplate(@Qualifier("eolDataSource") DataSource eolDataSource){
      return new JdbcTemplate(eolDataSource);
  }

  @Bean("eolEntityManager")
  @Primary
  public LocalContainerEntityManagerFactoryBean eolEntityManager(@Qualifier("eolDataSource") DataSource eolDataSource){
      LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
      em.setDataSource(eolDataSource);
      em.setPackagesToScan(new String[] { "cl.usach.mingeso.entity" });
      HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
      em.setJpaVendorAdapter(vendorAdapter);
      HashMap<String, Object> properties = new HashMap<>();
      properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
      properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
      em.setJpaPropertyMap(properties);
      return em;        
  }

  @Bean("eolTransactionManager")
  @Primary
  public PlatformTransactionManager eolTransactionManager(@Qualifier("eolEntityManager") LocalContainerEntityManagerFactoryBean eolEntityManager) {
      JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(eolEntityManager.getObject());
      return transactionManager;
  }
          
}