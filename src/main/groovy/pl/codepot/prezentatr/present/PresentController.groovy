package pl.codepot.prezentatr.present

import groovy.util.logging.Slf4j
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import pl.codepot.prezentatr.dto.Ingredient
import pl.codepot.prezentatr.dto.IngredientType
import pl.codepot.prezentatr.dto.Order


@RestController
@RequestMapping('/present')
@Slf4j
class PresentController {

    @RequestMapping(value="/order", method = RequestMethod.POST)
    ResponseEntity<Order> order(HttpEntity<String> body) {
        log.info "order method called"
        Order order = new Order()
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient(IngredientType.MALT, 200),
                new Ingredient(IngredientType.WATER, 200),
                new Ingredient(IngredientType.HOP, 200),
                new Ingredient(IngredientType.YIEST, 200),
        );
        order.setIngredients(ingredients)
        return new ResponseEntity<Order>(order, HttpStatus.OK)
    }

    @RequestMapping(value="/bottles", method = RequestMethod.GET)
    String presentBottles() {
        return "0"
    }
    @RequestMapping(value="/butelkatr", method=RequestMethod.GET)
    String presentButelkatr() {
        return "0"
    }

    @RequestMapping(value="/dojrzewatr", method=RequestMethod.GET)
    String presentDojrzewatr() {
        return "0"
    }

}
