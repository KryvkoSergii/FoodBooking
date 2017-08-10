package ua.ksa.FoodBooking;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.multipart.support.MultipartFilter;

import javax.servlet.ServletContext;

/**
 * Created by ksa on 08.08.17.
 */
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    @Override
    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
        MultipartFilter filter = new MultipartFilter();
        filter.setMultipartResolverBeanName("multipartResolver");
        insertFilters(servletContext, filter);
    }
}
