package com.jgcardelus.auth.service;

import com.jgcardelus.auth.model.DocumentModel;

public interface DocumentService {
    Iterable<DocumentModel> retrieveAll();
}
