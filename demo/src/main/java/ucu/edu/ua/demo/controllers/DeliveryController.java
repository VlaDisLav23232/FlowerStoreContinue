package ucu.edu.ua.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ucu.edu.ua.demo.delivery.DHLDeliveryStrategy;
import ucu.edu.ua.demo.delivery.PostDeliveryStrategy;
import ucu.edu.ua.demo.order.Item;
import ucu.edu.ua.demo.order.SimpleItem;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    private List<Item> sampleItems(int count) {
        java.util.ArrayList<Item> list = new java.util.ArrayList<>();
        for (int i = 0; i < Math.max(count, 0); i++) {
            list.add(new SimpleItem("Item-" + i, 1.0 + i));
        }
        return list;
    }

    @GetMapping("/post")
    public Map<String, Object> deliverByPost(@RequestParam(defaultValue = "2") int count) {
        var strategy = new PostDeliveryStrategy();
        var items = sampleItems(count);
        boolean success = strategy.deliver(items);
        return Map.of(
                "strategy", "post",
                "items", items.size(),
                "success", success
        );
    }

    @GetMapping("/dhl")
    public Map<String, Object> deliverByDhl(@RequestParam(defaultValue = "2") int count) {
        var strategy = new DHLDeliveryStrategy();
        var items = sampleItems(count);
        boolean success = strategy.deliver(items);
        return Map.of(
                "strategy", "dhl",
                "items", items.size(),
                "success", success
        );
    }
}
