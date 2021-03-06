package com.whisky.henallux.whisky.controller;

import com.whisky.henallux.whisky.dataAccess.dao.CategorieDAO;
import com.whisky.henallux.whisky.model.Panier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import static com.whisky.henallux.whisky.controller.CheckoutController.PANIER;

@Controller
@RequestMapping(value="/description")
@SessionAttributes({"mainPanier"})
public class DescriptionController {

    private CategorieDAO categorieDAO;

    @Autowired
    public DescriptionController(CategorieDAO categorieDAO)
    {
        this.categorieDAO = categorieDAO;
    }

    @ModelAttribute(PANIER)
    public Panier getPanier()
    {
        return new Panier();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model) {
        model.addAttribute("categorie", categorieDAO.getAllCategorie());
        return "integrated:description";
    }

}
