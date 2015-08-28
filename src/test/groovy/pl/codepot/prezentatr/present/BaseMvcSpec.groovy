package pl.codepot.prezentatr.present

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc
import spock.lang.Specification

class BaseMvcSpec extends Specification {

    def setup() {
        setupMocks()
        RestAssuredMockMvc.standaloneSetup(new FeedController(), new PresentController())
    }

    void setupMocks() {
    }



}
