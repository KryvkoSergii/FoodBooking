package ua.ksa.FoodBooking;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import ua.ksa.FoodBooking.config.AppConfig;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by ksa on 06.08.17.
 */
public class AppInitializer implements WebApplicationInitializer {

    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);
        //Binding MVC context to IoC
        rootContext.setServletContext(servletContext);
        DispatcherServlet servlet = new DispatcherServlet(rootContext);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", servlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
