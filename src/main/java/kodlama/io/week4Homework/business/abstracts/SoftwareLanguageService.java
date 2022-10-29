package kodlama.io.week4Homework.business.abstracts;

import kodlama.io.week4Homework.entities.concretes.SoftwareLanguage;

import java.util.List;

public interface SoftwareLanguageService {
    void add(SoftwareLanguage language);
    void delete(int id);
    void update(SoftwareLanguage language);
    SoftwareLanguage getById(int id);
    List<SoftwareLanguage> getAll();
}
