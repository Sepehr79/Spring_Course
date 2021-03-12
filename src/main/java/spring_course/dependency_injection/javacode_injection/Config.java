package spring_course.dependency_injection.javacode_injection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import spring_course.dependency_injection.javacode_injection.beans.Company;
import spring_course.dependency_injection.javacode_injection.beans.Pride;
import spring_course.dependency_injection.javacode_injection.beans.Samand;

@Configuration
@ComponentScan("spring_course.dependency_injection.javacode_injection.beans")
public class Config {

    @Bean
    public Company company(){
        return new Company("companyName", "companyNation");
    }

    @Bean(name = "pride", initMethod = "init", destroyMethod = "destroy")
    @Scope("prototype")
    public Pride getPride(){
        // Constructor injection
        return new Pride("mmm", company(), 2000);
    }

    @Bean
    public Samand samand(){ // method name will set to the bean id

        // Setter injection
        Samand samand = new Samand();

        samand.setName("mmm");

        //samand.setCompany(company()); Autowired

        samand.setYear(2020);

        return samand;
    }

}
