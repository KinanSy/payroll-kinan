package ch.etml.es.payroll.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeServiceProperties {
    private String url;

    public void setUrl (String url) {
        this.url = url;
    }


}
