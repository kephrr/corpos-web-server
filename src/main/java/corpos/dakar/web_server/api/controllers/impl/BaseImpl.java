package corpos.dakar.web_server.api.controllers.impl;

import corpos.dakar.web_server.api.dto.response.RestResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseImpl {
    public static Map<Object, Object> bindErrors(BindingResult bindingResult) {
        Map<String, String> errors =new HashMap<>();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        fieldErrors.forEach(fieldError -> errors.put(fieldError.getField(),fieldError.getDefaultMessage()));
        return RestResponseDto.response(errors, HttpStatus.NOT_ACCEPTABLE);
    }
}






