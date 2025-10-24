package ucu.edu.ua.demo.payment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentStrategyTests {

    @Test
    void creditCardPaymentSucceedsForValidData() {
        var cc = new CreditCardPaymentStrategy("4111111111111111", "John Doe", "123", "12/30");
        assertTrue(cc.pay(100.0));
    }

    @Test
    void creditCardPaymentFailsForInvalidAmount() {
        var cc = new CreditCardPaymentStrategy("4111111111111111", "John Doe", "123", "12/30");
        assertFalse(cc.pay(0));
    }

    @Test
    void paypalPaymentSucceedsForValidData() {
        var pp = new PayPalPaymentStrategy("user@example.com", "secret");
        assertTrue(pp.pay(50.0));
    }

    @Test
    void paypalPaymentFailsForEmptyCredentials() {
        var pp = new PayPalPaymentStrategy("", "");
        assertFalse(pp.pay(10.0));
    }
}
