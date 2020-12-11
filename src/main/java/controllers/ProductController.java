package controllers;

import entities.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import services.ProductService;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService = new ProductService();

    @GetMapping("/")
    public String index(Model model) {

        List productList = productService.findAll();
        model.addAttribute("products", productList);
        return "/index";
    }

    @GetMapping("/products/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/products/create")
    public String create(Product product,RedirectAttributes redirect) {
        product.setId((int)(Math.random() * 10000));
        productService.save(product);
        redirect.addFlashAttribute("success", "Create product successfully!");
        return "redirect:/";
    }

    @GetMapping("/products/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));

        return "/edit";
    }

    @PostMapping("/products/update")
    public String update(Product product, RedirectAttributes redirect) {
        productService.update(product.getId(), product);
        redirect.addFlashAttribute("success", "Update product successfully!");
        return "redirect:/";
    }

    @GetMapping("/products/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }

    @PostMapping("/products/delete")
    public String delete(Product customer, RedirectAttributes redirect) {
        productService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/products/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }

}