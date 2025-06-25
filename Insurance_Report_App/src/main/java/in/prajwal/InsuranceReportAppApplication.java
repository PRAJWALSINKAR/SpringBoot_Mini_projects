package in.prajwal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class InsuranceReportAppApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(InsuranceReportAppApplication.class, args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(InsuranceReportAppApplication.class);
    }
}
