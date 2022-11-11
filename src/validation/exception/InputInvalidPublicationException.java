package validation.exception;

import validation.StatusMessage;

public class InputInvalidPublicationException extends RuntimeException{
    public InputInvalidPublicationException() {
        super(StatusMessage.INVALID_INPUT_PUBLICATION.toString());
    }
}
