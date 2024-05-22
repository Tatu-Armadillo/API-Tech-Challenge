package br.com.fiap.pos.challenge.trips.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
    
    public NotFoundException() {
        super("Not Found Entity");
    }
    
    public NotFoundException(final String mensagem) {
        super("Not Found " + mensagem);
    }

}
