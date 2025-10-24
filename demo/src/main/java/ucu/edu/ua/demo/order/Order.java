package ucu.edu.ua.demo.order;

import ucu.edu.ua.demo.payment.Payment;
import ucu.edu.ua.demo.delivery.Delivery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private final List<Item> items = new ArrayList<>();
    private Payment payment;
    private Delivery delivery;

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public double calculateTotalPrice() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }

    public boolean processOrder() {
        if (payment == null || delivery == null) {
            throw new IllegalStateException("Payment and Delivery strategies must be set before processing the order");
        }
        double amount = calculateTotalPrice();
        boolean paid = payment.pay(amount);
        if (!paid) return false;
        return delivery.deliver(items);
    }
}
