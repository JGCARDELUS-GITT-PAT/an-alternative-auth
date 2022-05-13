package com.jgcardelus.auth.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("DOCUMENTS")
public class DocumentModel {
    @Id
    @Column("DOC_ID")
    private Long docId;

    @Column("DOC")
    private String doc;

    @Column("USER_ID")
    private Long userId;

    public DocumentModel() {
    }

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((docId == null) ? 0 : docId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DocumentModel other = (DocumentModel) obj;
        if (docId == null) {
            if (other.docId != null)
                return false;
        } else if (!docId.equals(other.docId))
            return false;
        return true;
    }
}