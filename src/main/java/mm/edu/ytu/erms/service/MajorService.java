package mm.edu.ytu.erms.service;

import mm.edu.ytu.erms.model.Major;

import java.util.List;

public interface MajorService {
    List<Major> getAll();
    Major getByCode(String code);
    Major create(Major major);
    Major update(Major major);
    void delete(String code);
}
