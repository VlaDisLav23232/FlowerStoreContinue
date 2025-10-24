package ucu.edu.ua.demo.delivery;

import ucu.edu.ua.demo.order.Item;

import java.util.List;

public class DHLDeliveryStrategy implements Delivery {
    @Override
    public boolean deliver(List<Item> items) {
        return items != null && !items.isEmpty();
    }
}
