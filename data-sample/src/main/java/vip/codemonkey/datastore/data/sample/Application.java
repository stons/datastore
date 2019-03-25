package vip.codemonkey.datastore.data.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan({"vip.codemonkey.datastore.data.sample.entity"})
@EnableJpaRepositories(basePackages = "vip.codemonkey.datastore.data.sample.repository")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
