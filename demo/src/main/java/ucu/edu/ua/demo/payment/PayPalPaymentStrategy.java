package ucu.edu.ua.demo.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class PayPalPaymentStrategy implements Payment {
    @Getter
    private final String email;
    @Getter
    private final String password;

    @Override
    public boolean pay(double amount) {
        return amount > 0 && email != null && !email.isBlank() && password != null && !password.isBlank();
    }
}
