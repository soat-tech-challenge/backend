package br.com.grupo63.techchallenge.core.application.usecase.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenericException extends Exception {
    private String name;
    private String description;
}
