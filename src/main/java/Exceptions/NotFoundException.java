package Exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String id) {
        super("Resource with ID " + id + " not found.");
    }
}

