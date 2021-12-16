package exception;

public class UserStoryIdNotFoundException extends RuntimeException {

    public UserStoryIdNotFoundException(String errorMsg) {
        super(errorMsg);
    }
}
