package ua.ksa.FoodBooking.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by ksa on 06.08.17.
 * http://websystique.com/springmvc/spring-mvc-4-and-spring-security-4-integration-example/
 */
@Configuration
@EnableWebMvc
@EnableJpaRepositories
@EnableJpaAuditing
@EnableTransactionManagement
@Import({SecurityConfiguration.class})
@ComponentScan("ua.ksa")
@PropertySource("classpath:application.properties")
public class AppConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private Environment env;

    @Bean(name = "DataSource")
    public DataSource dataSource() {
        HikariConfig conf = new HikariConfig();
        conf.setJdbcUrl("jdbc:sqlite:food_booking.db");
        conf.setDriverClassName("org.sqlite.JDBC");
        conf.setMaximumPoolSize(2);
        DataSource ds = new HikariDataSource(conf);
        return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(JpaVendorAdapter vendorAdapter,
                                                                       @Qualifier("DataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("ua.ksa");
        factory.setDataSource(dataSource);
        return factory;
    }

    @Bean
    @Primary
    @Description("Setting JPA vendor adapter")
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(Boolean.valueOf(env.getProperty("database.showSQL")));
        adapter.setGenerateDdl(true);
        adapter.setDatabasePlatform(env.getProperty("database.dialect"));
        return adapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSizePerFile(100000000);
        resolver.setMaxInMemorySize(100000000);
        resolver.setDefaultEncoding("utf8");
        return resolver;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }
}