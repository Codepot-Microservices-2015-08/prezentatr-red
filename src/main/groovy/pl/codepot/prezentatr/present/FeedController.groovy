package pl.codepot.prezentatr.present

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import pl.codepot.prezentatr.ProcessService

@RestController
@RequestMapping(value = "/feed", consumes = "application/vnd.pl.codepot.prezentatr.v1+json", produces = MediaType.APPLICATION_JSON_VALUE)
class FeedController {

    @Autowired
    FeedController(ProcessService processService) {
        this.processService = processService
    }

    private final ProcessService processService

    @RequestMapping(value = '/butelkatr', method = RequestMethod.PUT)
    HttpStatus butelkatr() {
        processService.addButelkatr()
        return HttpStatus.OK
    }

    @RequestMapping(value = '/dojrzewatr', method = RequestMethod.PUT)
    HttpStatus dojrzewatr() {
        processService.addDojrzewatr()
        return HttpStatus.OK
    }

    @RequestMapping(value = '/bottles/34', method = RequestMethod.PUT)
    HttpStatus bottle() {
        processService.addButelka()
        return HttpStatus.OK
    }
}
