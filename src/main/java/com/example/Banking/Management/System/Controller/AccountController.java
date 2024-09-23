package com.example.Banking.Management.System.Controller;

import com.example.Banking.Management.System.Entity.AccountCreation;
import com.example.Banking.Management.System.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping()
public class AccountController {

    @Autowired
    AccountService accountService;

    // Display the account creation form
    @GetMapping("/AccountCreation")
    public String AccountCreation(Model model) {
        model.addAttribute("accountCreation", new AccountCreation());
        return "AccountCreation";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") long id) {
        accountService.deleteAccount(id);
        return "redirect:/listDetails";
    }
    @RequestMapping("update/{id}")
    public String updateCustomer(@PathVariable("id") long id, Model model) {
        AccountCreation accountCreation = accountService.updateAccount(id);
        model.addAttribute("updateAccount", accountCreation);
        return "EditDetails";
    }
    @PostMapping("/save")
    public String addCustomer(@ModelAttribute AccountCreation accountCreation) {
        accountService.addAccount(accountCreation);
        return "redirect:/listDetails";
    }

    @GetMapping("/listDetails")
    public String listDetails(Model model) {
        List<AccountCreation> accounts = accountService.getAllAccounts();
        model.addAttribute("details", accounts);
        return "listDetails";
    }

    @GetMapping("/api")
    public ResponseEntity<List<AccountCreation>> getAccountDetails() {
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }

    @DeleteMapping("/api/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable long id) {
        return new ResponseEntity<>(accountService.deleteAccount(id), HttpStatus.OK);
    }


}
