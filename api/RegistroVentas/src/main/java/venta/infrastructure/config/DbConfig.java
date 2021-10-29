package venta.infrastructure.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import venta.repository.ClientesRepository;
import venta.repository.ProductosRepository;
import venta.repository.ProductosVendidosRepository;
import venta.repository.VentasRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Scope("singleton")
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories( entityManagerFactoryRef = "ventasEntityManagerFactory",
                        transactionManagerRef = "ventasTransactionManager",
                       basePackageClasses = {ClientesRepository.class, ProductosRepository.class,
                                            ProductosVendidosRepository.class, VentasRepository.class})
public class DbConfig {
    private final Environment env;
    private final VentasProperties ventasProperties;

    public DbConfig(Environment env, VentasProperties ventasProperties) {
        this.env = env;
        this.ventasProperties = ventasProperties;
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "db.datasource")
    public DataSource coreDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "ventasEntityManager")
    public EntityManager entityManager() {
        return entityManagerFactory().createEntityManager();
    }

    @Primary
    @Bean(name = "ventasEntityManagerFactory")
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(coreDataSource());
        emf.setJpaVendorAdapter(vendorAdapter);
        emf.setPackagesToScan("venta.domain.model");
        emf.setPersistenceUnitName("ventasPersistenceUnit");

        Properties properties = new Properties();
        properties.setProperty("hibernate.jdbc.lob.non_contextual_creation", "true");
        emf.setJpaProperties(properties);

        emf.afterPropertiesSet();
        return emf.getObject();
    }

    @Bean(name = "ventasTransactionManager")
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory());
    }
}
