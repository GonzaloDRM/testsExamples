package com.parameterized.test.service;

import com.parameterized.test.model.ObjectModel;
import com.parameterized.test.repository.ObjectRepository;
import org.springframework.stereotype.Service;

@Service
public class ObjectService {

    private ObjectRepository objectRepository;

    public ObjectService(ObjectRepository objectRepository){
        this.objectRepository = objectRepository;
    }

    @Transactional
    public ObjectModel testService(Long id){
        ObjectModel objectModel = objectRepository.findById(id);
        if (objectModel != null)
            return objectModel;

        return null;
    }
}
