package br.com.xpto.systems.xptosystems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CityNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CityNotFoundException(String message) {
        super(message);
    }


}
