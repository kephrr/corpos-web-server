package corpos.dakar.web_server.api.dto.response;

import org.springframework.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;

public class RestResponseDto {
    public static Map<Object, Object> response(Object results, Object pages,
                                               Object totalPages, Object totalItems,
                                               Object currentPage, HttpStatus status){
        Map<Object, Object> response = response(results, status);
        response.put("totalItems", totalItems);
        response.put("currentPage",currentPage);
        response.put("pages", pages);
        response.put("totalPages", totalPages);
        return response;
    }
    public static Map<Object, Object> response(Object results, HttpStatus status){
        Map<Object, Object> response = new HashMap<>();
        response.put("status", status.value());
        response.put("results", results);
        return response;
    }
}
