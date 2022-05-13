package com.jgcardelus.auth.service.impl;

import com.jgcardelus.auth.model.DocumentModel;
import com.jgcardelus.auth.repository.DocumentRepository;
import com.jgcardelus.auth.service.DocumentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentRepository repository;

    @Override
    public Iterable<DocumentModel> retrieveAll() {
        return repository.findAll();
    }

}
