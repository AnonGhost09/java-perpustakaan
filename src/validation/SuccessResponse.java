package validation;

public class SuccessResponse<T> extends  ResponseStatus {

    public SuccessResponse(T data) {//<T> agar bebas tipedatanya kita yang menentukan
        super(true, null, data);
    }

}
