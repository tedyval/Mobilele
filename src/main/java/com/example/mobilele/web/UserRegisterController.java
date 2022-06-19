package com.example.mobilele.web;

import com.example.mobilele.model.bindingModel.UserRegisterBindingModel;
import com.example.mobilele.model.serviceModel.UserServiceModel;
import com.example.mobilele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserRegisterController {
    private UserService userService;
    private ModelMapper modelMapper;

    public UserRegisterController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @ModelAttribute()
    public void user(Model model){
      model.addAttribute( "userRegisterBindingModel", new UserRegisterBindingModel());
    }

    @GetMapping("/users/register")
    public String register(Model model){
       model.addAttribute("existed",false);
       model.addAttribute("notMatched",false);
        return "auth-register";
    }

    @PostMapping("/users/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userRegisterBindingModel",userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel",bindingResult);
            return "redirect: /users/register";
        }

        boolean areMatched= userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword());

        if(!areMatched) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel",userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("notMatched",true);
           return "redirect: /users/register";
        }

        UserServiceModel  userServiceModel = modelMapper.map(userRegisterBindingModel,UserServiceModel.class);

        boolean isRegistered = userService.registerUser(userServiceModel);
        if(!isRegistered){

            return "redirect: /users/register";
        }

        return "redirect: /";
    }




}
