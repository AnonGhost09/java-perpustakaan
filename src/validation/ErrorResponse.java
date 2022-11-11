package validation;

public class ErrorResponse extends ResponseStatus{
    public ErrorResponse(String error){
        super(false, error,null);
    }
}
