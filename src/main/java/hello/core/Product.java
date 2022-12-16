package hello.core;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter

public class Product {
        private String name;
        private int price;
        private int stock;

}
