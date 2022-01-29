package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mappers.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.CredentialForm;
import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

@Service
public class CredentialService {

    CredentialMapper credentialMapper;
    EncryptionService encryptionService;

    public CredentialService(CredentialMapper credentialMapper, EncryptionService encryptionService) {
        this.credentialMapper = credentialMapper;
        this.encryptionService = encryptionService;
    }

    public List<Credentials> getAllCredentials(int userId){
        return this.credentialMapper.getAllCredentials(userId);
    }

    public Credentials findCredential(int credentialId ){return this.credentialMapper.findCredential(credentialId);}
    public void insertCredential(CredentialForm credentialForm, int userId) {
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[16];
        random.nextBytes(key);
        String encodedKey = Base64.getEncoder().encodeToString(key);
        String encryptedPassword = encryptionService.encryptValue(credentialForm.getCredentialPassword(), encodedKey);
        this.credentialMapper.insertCredential(new Credentials(null, credentialForm.getCredentialUrl(),
                credentialForm.getCredentialUsername(), encodedKey, encryptedPassword, userId));

    }
    public void updateCredential(CredentialForm credentialForm){
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[16];
        random.nextBytes(key);
        String encodedKey = Base64.getEncoder().encodeToString(key);
        String encryptedPassword = encryptionService.encryptValue(credentialForm.getCredentialPassword(), encodedKey);
        this.credentialMapper.updateCredential(credentialForm.getCredentialId(), credentialForm.getCredentialUrl(),
                credentialForm.getCredentialUsername(), encodedKey, encryptedPassword);

    }

    public void deleteCredential(int credentialId){
        this.credentialMapper.deleteCredential(credentialId);
    }
}
