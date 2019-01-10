package com.whisky.henallux.whisky.controller;

import com.whisky.henallux.whisky.dataAccess.dao.WhiskyDAO;
import com.whisky.henallux.whisky.model.Whisky;
import com.whisky.henallux.whisky.service.Panier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/whiskies")
public class WhiskiesController {
    private WhiskyDAO whiskyDAO;
    private Panier panier;
    private List<Whisky> whiskies;
    private String orderName = "ASC";
    private String orderPrice = "ASC";
    private boolean changePrice;
    private boolean changeName = true;
    private String categorie;

    @Autowired
    public WhiskiesController(WhiskyDAO whiskyDAO, Panier panier){
        this.whiskyDAO = whiskyDAO;
        this.whiskies = this.whiskyDAO.getAllWhisky();
        this.panier = panier;
    }

    @RequestMapping
    public String getAllWhisky(Model model){
        this.categorie = null;
        model.addAttribute("order", "ASC");
        this.whiskies = whiskyDAO.getAllWhiskyOrderByNameAsc();
        if(changePrice) {
            if (orderPrice.equals("ASC"))
                this.whiskies = whiskyDAO.getAllWhiskyOrderByPriceAsc();
            else
                this.whiskies = whiskyDAO.getAllWhiskyOrderByPriceDesc();
        } else{
            if (orderName.equals("ASC"))
                this.whiskies = whiskyDAO.getAllWhiskyOrderByNameAsc();
            else
                this.whiskies = whiskyDAO.getAllWhiskyOrderByNameDesc();
        }
        this.changeName = false;
        this.changePrice = false;
        model.addAttribute("whisky", this.whiskies);
        return "integrated:whiskies";
    }

    @RequestMapping(value = "/{categorie}")
    public String getAllSingleMalt(Model model, @PathVariable(value = "categorie") String categorie){
        this.categorie = categorie;
        model.addAttribute("order", "ASC");
        this.whiskies = whiskyDAO.getWhiskyByCategorieOrderByNameAsc(categorie);
        if(changePrice) {
            if (orderPrice.equals("ASC"))
                this.whiskies = whiskyDAO.getWhiskyByCategorieOrderByPriceAsc(categorie);
            else
                this.whiskies = whiskyDAO.getWhiskyByCategorieOrderByPriceDesc(categorie);
        } else{
            if (orderName.equals("ASC"))
                this.whiskies = whiskyDAO.getWhiskyByCategorieOrderByNameAsc(categorie);
            else
                this.whiskies = whiskyDAO.getWhiskyByCategorieOrderByNameDesc(categorie);
        }
        this.changeName = false;
        this.changePrice = false;
        model.addAttribute("whisky", whiskies);
        return "integrated:whiskies";
    }



    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addWhisky(HttpServletRequest request)
    {
        panier.addWhisky(whiskyDAO.getWhiskyById(Integer.parseInt(request.getParameter("whisky"))), Integer.parseInt(request.getParameter("quantity")));
        return "redirect:/whiskies";
    }

    @RequestMapping(value = "/addIndex", method = RequestMethod.POST)
    public String addWhisky2(HttpServletRequest request)
    {
        panier.addWhisky(whiskyDAO.getWhiskyById(Integer.parseInt(request.getParameter("whisky"))), Integer.parseInt(request.getParameter("quantity")));
        return "redirect:/index";
    }

    @RequestMapping(value = "orderName", method = RequestMethod.POST)
    public String changeOrderName(Model model, @ModelAttribute(value="order") String order){
        this.changeName = true;
        if(orderName.equals("ASC")) {
            orderName = "DESC";
        }
        else {
            orderPrice = "DESC";
            orderName = "ASC";
        }
        if(this.categorie!=null)
            return this.getAllSingleMalt(model,categorie);
        return this.getAllWhisky(model);
    }

    @RequestMapping(value = "orderPrice", method = RequestMethod.POST)
    public String changeOrderPrice(Model model, @ModelAttribute(value="order") String order){
        this.changePrice = true;
        if(orderPrice.equals("ASC")) {
            orderPrice = "DESC";
        }
        else {
            orderName = "DESC";
            orderPrice = "ASC";
        }
        if(this.categorie!=null)
            return this.getAllSingleMalt(model, categorie);
        return this.getAllWhisky(model);
    }
}
