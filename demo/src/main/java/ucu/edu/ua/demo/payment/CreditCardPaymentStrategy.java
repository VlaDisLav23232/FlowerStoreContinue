package ucu.edu.ua.demo.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class CreditCardPaymentStrategy implements Payment {
    @Getter
    private final String cardNumber;
    @Getter
    private final String cardHolder;
    @Getter
    private final String cvv;
    @Getter
    private final String expiry;
    @Override
    public boolean pay(double amount) {
        return amount > 0 && cardNumber != null && cardNumber.length() >= 12 && cvv != null && cvv.length() >= 3;
    }
}
