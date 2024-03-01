import javax.naming.AuthenticationException;
import java.util.Scanner;

public class JsAlert {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Отримати ім'я користувача та пароль від користувача
            System.out.println("Enter username:");
            String username = scanner.nextLine();

            System.out.println("Enter password:");
            String password = scanner.nextLine();

            //Виконайте автентифікацію
            authenticate(username, password);

            // Успішна автентифікація
            System.out.println("Login successful.");
        } catch (AuthenticationException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void authenticate(String username, String password) throws AuthenticationException {
        // Перевірте порожнє або нульове ім’я користувача
        if (username == null || username.trim().isEmpty()) {
            throw new AuthenticationException("Username cannot be empty or null.");
        }

        // Перевірте порожній або нульовий пароль
        if (password == null || password.trim().isEmpty()) {
            throw new AuthenticationException("Password cannot be empty or null.");
        }

        // Перевірте довжину пароля менше 6 символів
        if (password.length() < 6) {
            throw new AuthenticationException("Password must be at least 6 characters long.");
        }

        // Перевірте наявність попередньо визначеного імені користувача та пароля
        if (!"admin".equals(username) || !"admin123".equals(password)) {
            throw new AuthenticationException("Invalid username or password.");
        }
    }
}