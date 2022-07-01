package app.controllers;

import app.beans.Article;
import app.dao.ArticleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Controller
public class ArticlesFeedController {
    @Autowired
    ArticleDAO dao;

    @RequestMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("command", new Article());
        return "create_form";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("article") Article article){
        dao.save(article);
        return "redirect:/feed";
    }

    @RequestMapping("/feed")
    public String viewFeed(Model model){
        List<Article> list=dao.getList();
        model.addAttribute("list", list);
        return "viewfeed";
    }

    @RequestMapping(value="/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        Article article = dao.getById(id);
        model.addAttribute("command", article);
        return "edit_form";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("article") Article article){
        dao.update(article);
        return "redirect:/feed";
    }

    @RequestMapping(value="/drop/{id}", method = RequestMethod.GET)
    public String drop(@PathVariable int id){
        dao.drop(id);
        return "redirect:/feed";
    }
}