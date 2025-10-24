package ucu.edu.ua.demo.delivery;

import ucu.edu.ua.demo.order.Item;
import java.util.List;

public interface Delivery {
    boolean deliver(List<Item> items);
}
