package ucu.edu.ua.demo.delivery;

import org.junit.jupiter.api.Test;
import ucu.edu.ua.demo.order.Item;
import ucu.edu.ua.demo.order.SimpleItem;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DeliveryStrategyTests {

    private List<Item> items() {
        return List.of(new SimpleItem("A", 1.0), new SimpleItem("B", 2.0));
    }

    @Test
    void postDeliverySucceeds() {
        var post = new PostDeliveryStrategy();
        assertTrue(post.deliver(items()));
    }

    @Test
    void dhlDeliverySucceeds() {
        var dhl = new DHLDeliveryStrategy();
        assertTrue(dhl.deliver(items()));
    }

    @Test
    void deliveryFailsForEmptyList() {
        var dhl = new DHLDeliveryStrategy();
        var post = new PostDeliveryStrategy();
        assertFalse(dhl.deliver(List.of()));
        assertFalse(post.deliver(List.of()));
    }
}
