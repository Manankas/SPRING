package mg.socle.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {
		"${base.package}.dao" }, entityManagerFactoryRef = "myEntityManagerFactory", transactionManagerRef = "transactionManager")
@EnableTransactionManagement
@EnableLoadTimeWeaving

public class RepositoryConf {

	@Value("${socle.db.url}")
	private String dbUrl;
	@Value("${socle.db.driver}")
	private String driverClassName;
	@Value("${socle.db.user}")
	private String dbUser;
	@Value("${socle.db.password}")
	private String dbPassword;

	@Value("${technique.hibernate.dialect}")
	private String dialect;
	@Value("${technique.hibernate.show_sql}")
	private String showSql;
	@Value("${technique.hibernate.format_sql}")
	private String formatSql;
	@Value("${technique.hibernate.hbm2ddl.auto}")
	private String hbm2ddlAuto;
	@Value("${technique.hibernate.connection.pool_size}")
	private String poolSize;

	@Value("${base.package}")
	private String basePackage;

	@Bean(name = "loadTimeWeaver")
	public InstrumentationLoadTimeWeaver loadTimeWeaver() throws Throwable {
		InstrumentationLoadTimeWeaver loadTimeWeaver = new InstrumentationLoadTimeWeaver();
		return loadTimeWeaver;
	}

	/**
	 * <bean id="dataSourceJpa" class=
	 * "org.springframework.jdbc.datasource.DriverManagerDataSource">
	 * <property name="driverClassName" value="#{tech['socle.db.driver']}" />
	 * <property name="url" value="#{tech['socle.db.url']}" />
	 * <property name="username" value="#{tech['socle.db.user']}" />
	 * <property name="password" value="#{tech['socle.db.password']}" /> </bean>
	 */
	@Bean(name = "dataSourceJpa")
	public DriverManagerDataSource driverManagerDataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(dbUrl);
		driverManagerDataSource.setDriverClassName(driverClassName);
		driverManagerDataSource.setUsername(dbUser);
		driverManagerDataSource.setPassword(dbPassword);
		return driverManagerDataSource;
	}

	@Bean(name = "myEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

		Map<String, String> jpaProperties = new HashMap<String, String>();
		jpaProperties.put("hibernate.dialect", dialect);
		jpaProperties.put("hibernate.show_sql", showSql);
		jpaProperties.put("hibernate.format_sql", formatSql);
		jpaProperties.put("hibernate.hbm2ddl.auto", hbm2ddlAuto);
		jpaProperties.put("hibernate.connection.pool_size", poolSize);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan(basePackage + ".domain");
		factory.setDataSource(driverManagerDataSource());
		factory.setJpaPropertyMap(jpaProperties);
		factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
		factory.setPersistenceUnitName("prototypeUnit");
		return factory;
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return txManager;
	}

}
