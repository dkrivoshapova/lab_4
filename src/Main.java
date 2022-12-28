import java.io.IOException;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws IOException {
        String filename = "src/user.csv";
        FileAccountManager accountManager = new FileAccountManager(filename);
        Account a = new Account("Дмитрий Ершов", "01.10.2000", "de2000@mail.ru", "12345", false);
        Account b = new Account("Иванов Иван", "24.11.2005", "ii2005@mail.ru", "54321", false);

        try {
            accountManager.register(a);
        } catch (AccountAlreadyExistsException var25) {
            System.out.println(var25.getMessage());
        }

        try {
            accountManager.register(b);
        } catch (AccountAlreadyExistsException var24) {
            System.out.println(var24.getMessage());
        }

        try {
            accountManager.register(a);
        } catch (AccountAlreadyExistsException var23) {
            System.out.println(var23.getMessage());
        }

        try {
            accountManager.login(a.getEmail(), "123");
        } catch (AccountBlockedException | WrongCredentialsException var22) {
            System.out.println(var22.getMessage());
        }

        try {
            accountManager.login(b.getEmail(), "543");
        } catch (AccountBlockedException | WrongCredentialsException var21) {
            System.out.println(var21.getMessage());
        }

        try {
            accountManager.login(a.getEmail(), "123");
        } catch (AccountBlockedException | WrongCredentialsException var20) {
            System.out.println(var20.getMessage());
        }

        try {
            accountManager.login(a.getEmail(), "123");
        } catch (AccountBlockedException | WrongCredentialsException var19) {
            System.out.println(var19.getMessage());
        }

        try {
            accountManager.login(a.getEmail(), "123");
        } catch (AccountBlockedException | WrongCredentialsException var18) {
            System.out.println(var18.getMessage());
        }

        try {
            accountManager.login(a.getEmail(), "123");
        } catch (AccountBlockedException | WrongCredentialsException var17) {
            System.out.println(var17.getMessage());
        }

        try {
            accountManager.login(a.getEmail(), a.getPassword());
        } catch (AccountBlockedException | WrongCredentialsException var16) {
            System.out.println(var16.getMessage());
        }

        try {
            accountManager.login(b.getEmail(), "543");
        } catch (AccountBlockedException | WrongCredentialsException var15) {
            System.out.println(var15.getMessage());
        }

        try {
            accountManager.login(b.getEmail(), b.getPassword());
        } catch (AccountBlockedException | WrongCredentialsException var14) {
            System.out.println(var14.getMessage());
        }

        try {
            accountManager.login(b.getEmail(), "543");
        } catch (AccountBlockedException | WrongCredentialsException var13) {
            System.out.println(var13.getMessage());
        }

        try {
            accountManager.login(b.getEmail(), "543");
        } catch (AccountBlockedException | WrongCredentialsException var12) {
            System.out.println(var12.getMessage());
        }

        try {
            accountManager.login(b.getEmail(), "543");
        } catch (AccountBlockedException | WrongCredentialsException var11) {
            System.out.println(var11.getMessage());
        }

        try {
            accountManager.login(b.getEmail(), "543");
        } catch (AccountBlockedException | WrongCredentialsException var10) {
            System.out.println(var10.getMessage());
        }

        try {
            accountManager.login(b.getEmail(), b.getPassword());
        } catch (AccountBlockedException | WrongCredentialsException var9) {
            System.out.println(var9.getMessage());
        }

        try {
            accountManager.removeAccount(a.getEmail(), a.getPassword());
        } catch (WrongCredentialsException var8) {
            System.out.println(var8.getMessage());
        }

        try {
            accountManager.removeAccount(b.getEmail(), "654");
        } catch (WrongCredentialsException var7) {
            System.out.println(var7.getMessage());
        }

        try {
            accountManager.removeAccount(b.getEmail(), b.getPassword());
        } catch (WrongCredentialsException var6) {
            System.out.println(var6.getMessage());
        }

    }
}