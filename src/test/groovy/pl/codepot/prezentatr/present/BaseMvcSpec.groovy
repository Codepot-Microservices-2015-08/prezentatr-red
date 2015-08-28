package pl.codepot.prezentatr.present

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc
import pl.codepot.prezentatr.ProcessService
import pl.codepot.prezentatr.dto.Ingredient
import pl.codepot.prezentatr.dto.IngredientType
import pl.codepot.prezentatr.dto.Order
import pl.codepot.prezentatr.service.IngredientService
import spock.lang.Specification

class BaseMvcSpec extends Specification {

    def setup() {
        setupMocks()
        IngredientService ingredientService = Mock(IngredientService)

        ingredientService.getIngredients(_) >> new Order(ingredients: [new Ingredient(IngredientType.MALT, 200),
                                                                       new Ingredient(IngredientType.WATER, 200),
                                                                       new Ingredient(IngredientType.HOP, 200),
                                                                       new Ingredient(IngredientType.YIEST, 200)])

        ProcessService processService = Mock(ProcessService)
        processService.getDojrzewatrCount() >> 0
        processService.getButelkowanieCount() >> 0
        processService.getButelkiCount() >> 0
        RestAssuredMockMvc.standaloneSetup(new FeedController(processService), new PresentController(ingredientService, processService))
    }

    void setupMocks() {
    }


}
