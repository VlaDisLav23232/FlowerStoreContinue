package ucu.edu.ua.demo.flowers;

import java.util.ArrayList;
import java.util.List;

public class FlowerBucket {
    private final List<FlowerPack> flowerPacks = new ArrayList<>();

    public void add(FlowerPack flowerPack) {
        this.flowerPacks.add(flowerPack);
    }

    public double getPrice() {
        return flowerPacks.stream().mapToDouble(FlowerPack::getPrice).sum();
    }
}
