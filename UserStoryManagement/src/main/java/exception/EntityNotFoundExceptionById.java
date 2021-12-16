package exception;

public class EntityNotFoundExceptionById extends RuntimeException{
    public EntityNotFoundExceptionById(String errorMsg) {
        super(errorMsg);
    }
}
