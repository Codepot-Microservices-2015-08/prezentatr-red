package pl.codepot.prezentatr.present

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/feed", consumes = "application/vnd.pl.codepot.prezentatr.v1+json", produces = MediaType.APPLICATION_JSON_VALUE)
class FeedController {

    @RequestMapping(value = '/butelkatr', method = RequestMethod.PUT)
    HttpStatus butelkatr() {
        return HttpStatus.OK
    }

    @RequestMapping(value = '/dojrzewatr', method = RequestMethod.PUT)
    HttpStatus dojrzewatr() {
        return HttpStatus.OK
    }

    @RequestMapping(value = '/bottles/34', method = RequestMethod.PUT)
    HttpStatus bottle() {
        return HttpStatus.OK
    }
}
