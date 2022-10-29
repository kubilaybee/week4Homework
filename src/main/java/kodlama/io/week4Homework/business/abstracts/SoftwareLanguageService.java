package kodlama.io.week4Homework.business.abstracts;

import kodlama.io.week4Homework.entities.concretes.SoftwareLanguage;

import java.util.List;

public interface SoftwareLanguageService {
    List<SoftwareLanguage> getAll();
}
