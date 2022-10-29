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
    public List<SoftwareLanguage> getAll() {
        return this.repository.getAll();
    }
}
