package net.montimur.tacocloud.controller;

import lombok.extern.slf4j.Slf4j;
import net.montimur.tacocloud.domain.Ingredient;
import net.montimur.tacocloud.domain.Ingredient.Type;
import net.montimur.tacocloud.domain.Taco;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    @GetMapping
    public String showDesignForm(Model model) {
        var ingredients = List.of(
                new Ingredient("FLTO", "Flout Tortilla", Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                new Ingredient("TMTO", "Tomato", Type.VEGGIE),
                new Ingredient("LETC", "Lettuce", Type.VEGGIE),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterrey", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        );

        for (var type : Type.values())
            model.addAttribute(type.toString().toLowerCase(),
                    ingredients.stream().filter(ingredient -> ingredient.getType() == type).collect(Collectors.toList()));

        model.addAttribute("design", new Taco());

        return "design";
    }
}
