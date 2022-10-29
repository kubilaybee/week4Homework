package kodlama.io.week4Homework.webApi.controllers;

import kodlama.io.week4Homework.business.abstracts.SoftwareLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/softwarelanguages")
public class SoftwareLanguageControllers {
    private SoftwareLanguageService languageService;

    @Autowired
    public SoftwareLanguageControllers(SoftwareLanguageService languageService) {
        this.languageService = languageService;
    }
    // --
}
