package ucu.edu.ua.demo.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class SimpleItem implements Item {
    @Getter
    private final String description;
    @Getter
    private final double price;
}
