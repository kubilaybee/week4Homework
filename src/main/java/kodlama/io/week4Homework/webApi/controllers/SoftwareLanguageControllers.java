package kodlama.io.week4Homework.webApi.controllers;

import kodlama.io.week4Homework.business.abstracts.SoftwareLanguageService;
import kodlama.io.week4Homework.entities.concretes.SoftwareLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/softwarelanguages")
public class SoftwareLanguageControllers {
    private SoftwareLanguageService languageService;

    @Autowired
    public SoftwareLanguageControllers(SoftwareLanguageService languageService) {
        this.languageService = languageService;
    }
    // delete func
    @DeleteMapping("/delete/{id}")
    public List<SoftwareLanguage> getSoftwareLanguage(@PathVariable int id){
        for (SoftwareLanguage tempLanguage:languageService.getAll()){
            if (tempLanguage.getId()==id){
                this.languageService.delete(tempLanguage.getId());
            }
        }
        return null;
    }

    @GetMapping("/languages")
    public List<SoftwareLanguage> getAll(){
        return languageService.getAll();
    }

    // getID func
    @GetMapping("/get/{id}")
    public SoftwareLanguage getByIdSoftwareLanguage(@PathVariable int id){
        return languageService.getById(id);
    }

    // update func
    @PutMapping("/update/{language}")
    public List<SoftwareLanguage> updateSoftwareLanguage(@PathVariable SoftwareLanguage language){
        languageService.update(language);
        return languageService.getAll();
    }

    // add func
    @PostMapping("/update/{language}")
    public List<SoftwareLanguage> addSoftwareLanguage(SoftwareLanguage softwareLanguage){
        for (SoftwareLanguage tempLanguage:languageService.getAll()){
            if (tempLanguage.getName()==softwareLanguage.getName()){
                throw new RuntimeException("The language is already exist.");
            }
        }
        return languageService.getAll();
    }

}
