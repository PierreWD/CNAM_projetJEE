package org.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContactController {

    private final ContactRepository contactRepository;

    ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping("/contact")
    public String contact(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        Contact contactAdd = new Contact();
        List<Contact> contactList= contactRepository.findAll();
        model.addAttribute("contactList",contactList);
        model.addAttribute("contactAdd",contactAdd);
        return "contact";
    }

    @PostMapping("/AddContact")
    public String AddContact(@ModelAttribute("contactAdd") Contact contact, Model model) {
        contactRepository.save(contact);
        List<Contact> contactList= contactRepository.findAll();
        Contact contactAdd = new Contact();
        model.addAttribute("contactAdd",contactAdd);
        model.addAttribute("contactList",contactList);
        return "contact";
    }

    @PostMapping("/UpdateContact")
    public String UpdateContact(@ModelAttribute("contactAdd") Contact contact, Model model) {
        contactRepository.save(contact);
        List<Contact> contactList= contactRepository.findAll();
        Contact contactAdd = new Contact();
        model.addAttribute("contactAdd",contactAdd);
        model.addAttribute("contactList",contactList);
        return "contact";
    }

    @PostMapping("/DeleteContact")
    public String DeleteContact(@RequestParam(name="contactId", required=true) Long contactId, Model model) {
        Contact contact= contactRepository.getById(contactId);
        contactRepository.delete(contact);
        List<Contact> contactList= contactRepository.findAll();
        Contact contactAdd = new Contact();
        model.addAttribute("contactAdd",contactAdd);
        model.addAttribute("contactList",contactList);
        return "contact";
    }

}


