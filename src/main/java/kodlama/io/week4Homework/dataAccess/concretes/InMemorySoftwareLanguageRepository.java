package kodlama.io.week4Homework.dataAccess.concretes;

import kodlama.io.week4Homework.dataAccess.abstracts.SoftwareLanguageRepository;
import kodlama.io.week4Homework.entities.concretes.SoftwareLanguage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemorySoftwareLanguageRepository implements SoftwareLanguageRepository {

    private List<SoftwareLanguage> softwareLanguages;

    public InMemorySoftwareLanguageRepository(){
        this.softwareLanguages = new ArrayList<SoftwareLanguage>();
        // define the example datas
        this.softwareLanguages.add(new SoftwareLanguage(0,"C#"));
        this.softwareLanguages.add(new SoftwareLanguage(1,"Python"));
        this.softwareLanguages.add(new SoftwareLanguage(2,"Java"));
        this.softwareLanguages.add(new SoftwareLanguage(3,"JavaScript"));
        this.softwareLanguages.add(new SoftwareLanguage(4,"C++"));
    }

    @Override
    public void add(SoftwareLanguage language) {
        for (SoftwareLanguage tempLanguage:softwareLanguages){
            if (tempLanguage.getName()==language.getName()){
                throw new RuntimeException("The language is already exist.");
            }
        }
        this.softwareLanguages.add(language);
    }

    @Override
    public void delete(int id) {
        for (SoftwareLanguage tempLanguage:softwareLanguages){
            if (tempLanguage.getId()==id){
                this.softwareLanguages.remove(tempLanguage.getId());
            }
        }
    }

    @Override
    public void update(SoftwareLanguage language) {
        for (SoftwareLanguage tempLanguage:softwareLanguages){
            if (tempLanguage.getId()==language.getId()){
                tempLanguage.setName(language.getName());
            }
        }
    }

    @Override
    public SoftwareLanguage getById(int id) {
        for (SoftwareLanguage tempLanguage:softwareLanguages){
            if (tempLanguage.getId()==id){
                return tempLanguage;
            }
        }
        return null;
    }

    @Override
    public List<SoftwareLanguage> getAll() {
        return this.softwareLanguages;
    }
}
