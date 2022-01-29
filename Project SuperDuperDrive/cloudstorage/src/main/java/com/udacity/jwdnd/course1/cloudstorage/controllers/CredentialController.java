package com.udacity.jwdnd.course1.cloudstorage.controllers;

import com.udacity.jwdnd.course1.cloudstorage.model.CredentialForm;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CredentialController {
    CredentialService credentialService;
    UserService userService;

    public CredentialController(CredentialService credentialService, UserService userService) {
        this.credentialService = credentialService;
        this.userService = userService;
    }

    @PostMapping("/home/credential")
    public String sendCredentialData(Model model, Authentication authentication, @ModelAttribute("credentialForm") CredentialForm credentialForm){
        if(credentialForm.getCredentialUrl() != null && credentialForm.getCredentialUsername() != null && credentialForm.getCredentialPassword() != null) {
            if(credentialForm.getCredentialId() == null) {
                this.credentialService.insertCredential(credentialForm, this.userService.getUser(authentication.getName()).getUserId());
                return "redirect:/result?success=true&errorMsg=0";
            }
            else{
                if(this.credentialService.findCredential(credentialForm.getCredentialId()).getUserId() == this.userService.getUser(authentication.getName()).getUserId()) {
                    this.credentialService.updateCredential(credentialForm);
                    return "redirect:/result?success=true&errorMsg=0";
                }
                else{
                    return "redirect:/result?success=false&errorMsg=2";
                }
            }
        }
        else{
            return "redirect:/result?success=false&errorMsg=3";
        }
    }
    @GetMapping("/home/credential/delete/{credentialId}")
    public String deleteCredential(@PathVariable int credentialId, Authentication authentication){
        if(this.credentialService.findCredential(credentialId).getUserId() == this.userService.getUser(authentication.getName()).getUserId()) {
            this.credentialService.deleteCredential(credentialId);
            return "redirect:/result?success=true";
        }
        else{
            return "redirect:/result?success=false&errorMsg=2";
        }
    }
}
