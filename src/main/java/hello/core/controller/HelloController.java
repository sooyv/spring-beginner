package hello.core.controller;

import hello.core.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    //hello url을 매핑
//    @GetMapping("hello")
//    public String hello(Model model) {
//        model.addAttribute("data", "World!");
//        //hello.html을 client에 던져주겠다(return)
//        return "hello";//.html
//    }

    @GetMapping("hello")
    @ResponseBody
    public Product helloString(@RequestParam("name") String name,
                               @RequestParam("price") int price,
                               @RequestParam("stock") int stock) {
        Product water = new Product();
        water.setName(name);
        water.setPrice(price);
        water.setStock(stock);

        return water;
    }

}
