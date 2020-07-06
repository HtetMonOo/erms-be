package mm.edu.ytu.erms.service;

import mm.edu.ytu.erms.model.Subject;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class SubjectServiceImpl implements SubjectService {
    private static Map<String, Subject> subjectRepo = new HashMap<>();

    @Override
    public void createSubject(Subject subject) {
        subjectRepo.put(subject.getCode(), subject);
    }
    @Override
    public void updateSubject(String code, Subject subject) {
        subjectRepo.remove(code);
        subject.setCode(code);
        subjectRepo.put(code, subject);
    }
    @Override
    public void deleteSubject(String code) {
        subjectRepo.remove(code);

    }
    @Override
    public Collection<Subject> getSubjects() {
        return subjectRepo.values();
    }
}
