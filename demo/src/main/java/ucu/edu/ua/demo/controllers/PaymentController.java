package ucu.edu.ua.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ucu.edu.ua.demo.payment.CreditCardPaymentStrategy;
import ucu.edu.ua.demo.payment.PayPalPaymentStrategy;

import java.util.Map;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @GetMapping("/credit-card")
    public Map<String, Object> payByCreditCard(
            @RequestParam double amount,
            @RequestParam String cardNumber,
            @RequestParam String cardHolder,
            @RequestParam String cvv,
            @RequestParam String expiry
    ) {
        var strategy = new CreditCardPaymentStrategy(cardNumber, cardHolder, cvv, expiry);
        boolean success = strategy.pay(amount);
        return Map.of(
                "method", "credit-card",
                "amount", amount,
                "success", success
        );
    }

    @GetMapping("/paypal")
    public Map<String, Object> payByPaypal(
            @RequestParam double amount,
            @RequestParam String email,
            @RequestParam String password
    ) {
        var strategy = new PayPalPaymentStrategy(email, password);
        boolean success = strategy.pay(amount);
        return Map.of(
                "method", "paypal",
                "amount", amount,
                "success", success
        );
    }
}
