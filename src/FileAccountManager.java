import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class FileAccountManager implements AccountManager {
    final ArrayList<Account> group;
    final String filename;

    public FileAccountManager(String str) throws IOException {
        this.filename = str;
        this.group = FileService.readCSV(this.filename);
    }

    public void register(Account account) throws IOException {
        Iterator var2 = this.group.iterator();

        Account i;
        do {
            if (!var2.hasNext()) {
                System.out.println(account.getEmail() + " вы успешно зарегистрированы");
                this.group.add(account);
                FileService.writeCSV(this.filename, this.group);
                return;
            }

            i = (Account)var2.next();
        } while(!i.getEmail().equals(account.getEmail()));

        throw new AccountAlreadyExistsException("Пользователь уже зарегистрирован на  почту ", account.getEmail());
    }

    public Account login(String email, String password) throws AccountBlockedException, WrongCredentialsException {
        Iterator var3 = this.group.iterator();

        Account i;
        do {
            if (!var3.hasNext()) {
                throw new WrongCredentialsException("Пользователя с таким логином или паролем не существует ", email, password);
            }

            i = (Account)var3.next();
            if (i.getEmail().equals(email) && i.getPassword().equals(password)) {
                if (i.isBlocked()) {
                    throw new AccountBlockedException("Ошибка, ваш аккаунт заблокирован ", i.getEmail());
                }

                FailedLoginCounter.clean(i);
                System.out.println(i.getEmail() + " вход выполнен успешно.");
                return i;
            }
        } while(!i.getEmail().equals(email) && !i.getPassword().equals(password));

        FailedLoginCounter.countFaildLogin(i);
        if (!i.isBlocked()) {
            throw new WrongCredentialsException("Ошибка, неправильный логин или пароль ", email, password);
        } else {
            throw new WrongCredentialsException("Ошибка, ваш аккаунт заблокирован ", email, password);
        }
    }

    public void removeAccount(String email, String password) throws WrongCredentialsException {
        boolean isExist = false;
        Iterator var4 = this.group.iterator();

        while(var4.hasNext()) {
            Account i = (Account)var4.next();
            if (i.getEmail().equals(email) && i.getPassword().equals(password)) {
                System.out.println(i.getEmail() + " Аккаунт удален.");
                this.group.remove(i);
                isExist = true;

                try {
                    FileService.writeCSV("src/user.csv", this.group);
                } catch (IOException var7) {
                    var7.printStackTrace();
                }
                break;
            }
        }

        if (!isExist) {
            throw new WrongCredentialsException("Ошибка, невозможно удлить пользователя, попробуйте снова ", email, password);
        }
    }
}