package mm.edu.ytu.erms.service;

import mm.edu.ytu.erms.model.Major;

import java.util.List;

public interface MajorService {
    List<Major> getAll(Integer pageNo, Integer pageSize);
    Major getById(String code);
    Major create(Major major);
    Major update(Major major);
    void delete(String code);
}
