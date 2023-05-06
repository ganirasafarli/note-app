package noteappp.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {
    private int statusCode;
    private String message;
}
