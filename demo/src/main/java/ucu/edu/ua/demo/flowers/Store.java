package ucu.edu.ua.demo.flowers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Store {
    private final List<Flower> inventory = new ArrayList<>();

    public void addFlower(Flower flower) {
        inventory.add(flower);
    }

    public List<Flower> search(SearchFilter filter) {
        return inventory.stream()
                .filter(filter::matches)
                .collect(Collectors.toList());
    }
}
