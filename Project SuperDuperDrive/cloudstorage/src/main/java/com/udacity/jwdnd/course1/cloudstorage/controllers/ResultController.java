package com.udacity.jwdnd.course1.cloudstorage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResultController {

    @GetMapping("/result")
    public String getResult(@RequestParam("success") boolean success, @RequestParam("errorMsg") int errorMsg, Model model){

        if(success){
            model.addAttribute("success", true);
            model.addAttribute("error", false);
            model.addAttribute("errorMsg", "");
        }
        else{
            model.addAttribute("success",false);
            model.addAttribute("error", true);
            switch (errorMsg){
                case 1:
                    model.addAttribute("errorMsg", "Cannot upload two files of same name.");
                    break;
                case 2:
                    model.addAttribute("errorMsg", "Cannot make direct request to other user's file/note/credential");
                    break;
                case 3:
                    model.addAttribute("errorMsg", "Empty Parameter(s)");
                    break;
            }

        }
        return "result";


    }
}
