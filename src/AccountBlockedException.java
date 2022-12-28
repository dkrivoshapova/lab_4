public class AccountBlockedException extends RuntimeException {
    final String email;

    public String getEmail() {
        return this.email;
    }

    public AccountBlockedException(String message, String email) {
        super(message + email);
        this.email = email;
    }
}
