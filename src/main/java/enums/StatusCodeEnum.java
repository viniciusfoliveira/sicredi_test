package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum StatusCodeEnum {

    SUCCESS(200),
    CREATED(201),
    BAD_REQUEST(400),
    NOT_AUTORIZATION(401);

    private int statusCode;




}
