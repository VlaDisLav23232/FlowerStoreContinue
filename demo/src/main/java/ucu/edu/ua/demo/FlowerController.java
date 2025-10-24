package ucu.edu.ua.demo;

public class FlowerController {

@RestController
@RequestMapping("/flowers")
public class FlowerController {
    @GetMapping("/")
    public String listFlowers() {
        return "List of flowers";
    }
}
