package org.example.servingwebcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.List;

@Controller
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private AdressesElectroniquesRepository adressesElectroniquesRepository;

    @Autowired
    private AdressesPostalesRepository adressesPostalesRepository;

    @GetMapping("/contact")
    public String contact( Model model) {
        Contact contactAdd = new Contact();
        List<Contact> contactList= contactRepository.findAll();
        model.addAttribute("contactList",contactList);
        model.addAttribute("contactAdd",contactAdd);
        return "contact";
    }

    @GetMapping(value="/xml/contact/{contactId}",produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public String xmlContact(@PathVariable (name="contactId", required=true) Long contactId ) throws JAXBException {
        Contact contact= contactRepository.getById(contactId);
        JAXBContext jaxbContext = JAXBContext.newInstance(Contact.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(contact, stringWriter);
        return stringWriter.toString();
    }

    @GetMapping(value="/xml/contacts",produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public Listcontact xmlContacts()  {
        List<Contact> contactList= contactRepository.findAll();
        Listcontact listcontact=new Listcontact(contactList);
        return listcontact;
    }

    @PostMapping("/AddContact")
    public String AddContact(@ModelAttribute("contactAdd") Contact contact, Model model) {
        //AdressesElectroniques a = adressesElectroniquesRepository.getById(1L);
        //AdressesPostales b = adressesPostalesRepository.getById(1L);
        //contact.setEmail(a);
        //contact.setAdresse(b);
        contactRepository.save(contact);
        List<Contact> contactList= contactRepository.findAll();
        Contact contactAdd = new Contact();
        model.addAttribute("contactAdd",contactAdd);
        model.addAttribute("contactList",contactList);
        return "contact";
    }

    @PostMapping("/UpdateContact")
    public String UpdateContact(@ModelAttribute("contactAdd") Contact contact, Model model) {
        //AdressesElectroniques a = adressesElectroniquesRepository.getById(1L);
        //AdressesPostales b = adressesPostalesRepository.getById(1L);
        //contact.setEmail(a);
        //contact.setAdresse(b);
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


