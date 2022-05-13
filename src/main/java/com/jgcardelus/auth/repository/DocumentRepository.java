package com.jgcardelus.auth.repository;

import com.jgcardelus.auth.model.DocumentModel;

import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<DocumentModel, Long> {
    
}
