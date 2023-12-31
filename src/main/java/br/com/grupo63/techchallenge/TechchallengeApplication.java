package br.com.grupo63.techchallenge;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.Servers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(title = "${info.name}", description = "${info.description}", version = "${info.version}"),
        servers ={
                @Server(url = "/", description = "Current URL"),
                @Server(url = "localhost:8080", description = "Local"),
                @Server(url = "${docs.api.url}", description = "API Gateway Invoke URL")
        })
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
@SpringBootApplication
public class TechchallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechchallengeApplication.class, args);
    }

}
