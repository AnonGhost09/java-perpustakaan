package validation.exception;

import validation.StatusMessage;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException() {
        super(StatusMessage.DATA_IS_EMPTY.toString());//pesan message saat terjadi error
    }
}
