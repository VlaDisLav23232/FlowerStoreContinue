package ucu.edu.ua.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ucu.edu.ua.demo.flowers.Flower;
import ucu.edu.ua.demo.flowers.FlowerColor;
import ucu.edu.ua.demo.flowers.FlowerType;
import ucu.edu.ua.demo.flowers.Rose;

import java.util.List;

@RestController
@RequestMapping("/flowers")
public class FlowerController {

    @GetMapping
    public List<Flower> listFlowers() {
        Rose rose = new Rose();
        rose.setSepalLength(5.0);
        rose.setPrice(10.5);

        Flower tulip = new Flower();
        tulip.setFlowerType(FlowerType.TULIP);
        tulip.setSepalLength(4.0);
        tulip.setPrice(7.25);
        tulip.setColor(FlowerColor.BLUE);

        return List.of(rose, tulip);
    }
}
