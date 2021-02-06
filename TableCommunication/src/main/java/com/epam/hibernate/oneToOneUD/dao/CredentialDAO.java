package com.epam.hibernate.oneToOneUD.dao;

import com.epam.hibernate.oneToOneUD.Credential;

public interface CredentialDAO {
    void saveCredential(Credential credential);
    void updateCredential(Credential credential);
    Credential getCredential(int id);
}
