package kodlama.io.week4Homework.business.concretes;

import kodlama.io.week4Homework.business.abstracts.SoftwareLanguageService;
import kodlama.io.week4Homework.dataAccess.abstracts.SoftwareLanguageRepository;
import kodlama.io.week4Homework.entities.concretes.SoftwareLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareLanguageManager implements SoftwareLanguageService {
    private SoftwareLanguageRepository repository;

    @Autowired
    public SoftwareLanguageManager(SoftwareLanguageRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(SoftwareLanguage language) {
        for (SoftwareLanguage tempLanguage:repository.getAll()){
            if (tempLanguage.getName()==language.getName()){
                throw new RuntimeException("The language is already exist.");
            }
        }
        this.repository.add(language);
    }

    @Override
    public void delete(int id) {
        for (SoftwareLanguage tempLanguage: repository.getAll()){
            if (tempLanguage.getId()==id){
                this.repository.delete(tempLanguage.getId());
        }
    }
    }

    @Override
    public void update(SoftwareLanguage language) {
        for (SoftwareLanguage tempLanguage:repository.getAll()){
            if (tempLanguage.getId()==language.getId()){
                tempLanguage.setName(language.getName());
            }
        }
    }

    @Override
    public SoftwareLanguage getById(int id) {
        for (SoftwareLanguage tempLanguage:repository.getAll()){
            if (tempLanguage.getId()==id){
                return tempLanguage;
            }
        }
        return null;
    }

    @Override
    public List<SoftwareLanguage> getAll() {
        return this.repository.getAll();
    }
}
