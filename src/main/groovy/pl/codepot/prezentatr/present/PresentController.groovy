package pl.codepot.prezentatr.present
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import pl.codepot.prezentatr.dto.IngredientTypes
import pl.codepot.prezentatr.dto.Order
import pl.codepot.prezentatr.service.IngredientService

@RestController
@RequestMapping('/present')
@Slf4j
class PresentController {

    private final IngredientService ingredientService;

    @Autowired
    PresentController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @RequestMapping(value="/order", method = RequestMethod.POST)
    ResponseEntity<Order> order(IngredientTypes ingredientTypes) {
        log.info "order method called"
        Order order = ingredientService.getIngredients(ingredientTypes)

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
