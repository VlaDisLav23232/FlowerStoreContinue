package ucu.edu.ua.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ucu.edu.ua.demo.flowers.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FlowerBucketTests {

	@Test
	void bucketPriceIsSumOfPacks() {
		Flower rose = new Rose();
		rose.setPrice(10.0);
		Flower tulip = new Flower();
		tulip.setFlowerType(FlowerType.TULIP);
		tulip.setPrice(7.5);

		FlowerPack pack1 = new FlowerPack(rose, 3);
		FlowerPack pack2 = new FlowerPack(tulip, 2);

		FlowerBucket bucket = new FlowerBucket();
		bucket.add(pack1);
		bucket.add(pack2);

		double price = bucket.getPrice();

		assertEquals(45.0, price, 1e-9);
	}

	@Test
	void emptyBucketHasZeroPrice() {
		FlowerBucket bucket = new FlowerBucket();
		assertEquals(0.0, bucket.getPrice(), 1e-9);
	}

	@Test
	void singlePackPriceIsQuantityTimesFlowerPrice() {
		Flower flower = new Flower();
		flower.setPrice(5.25);
		FlowerPack pack = new FlowerPack(flower, 4);

		FlowerBucket bucket = new FlowerBucket();
		bucket.add(pack);

		assertEquals(21.0, bucket.getPrice(), 1e-9);
	}
}
