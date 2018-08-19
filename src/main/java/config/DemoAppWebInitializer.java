package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
 * 继承AbstractAnnotationConfigDispatcherServletInitializer配置Servlet容器。
 * 这个类由实现了Servlet3.0规范的容器自动调用。
 */
public class DemoAppWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    /*
     * AbstractAnnotationConfigDispatcherServletInitializer会同时创建DispatcherServlet和ContextLoaderListener。
     * getRootConfigClasses方法返回的带有@Configuration注解的类会用来定义ContextLoaderListener创建的应用上下文中的bean。
     */
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    /*
     * AbstractAnnotationConfigDispatcherServletInitializer会同时创建DispatcherServlet和ContextLoaderListener。
     * getServletConfigClasses方法返回的带有@Configuration注解的类会用来定义DispatcherServlet应用上下文中的bean。
     */
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    /*
     * 将DispatcherServlet映射到/。
     */
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
