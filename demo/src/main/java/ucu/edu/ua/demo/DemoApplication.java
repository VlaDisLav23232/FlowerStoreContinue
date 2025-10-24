package ucu.edu.ua.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import ucu.edu.ua.demo.flowers.Flower;
import ucu.edu.ua.demo.flowers.FlowerColor;
import ucu.edu.ua.demo.flowers.FlowerType;
import ucu.edu.ua.demo.flowers.Rose;
 

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "Hello, World!";
	}

	@GetMapping("/strings")
	public List<String> strings() {
		return List.of("Spring", "Boot", "Rocks");
	}

	@GetMapping("/numbers")
	public List<Integer> numbers() {
		return List.of(1, 2, 3, 4, 5);
	}

	@GetMapping("/demo/flowers")
	public List<Flower> demoFlowers() {
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
