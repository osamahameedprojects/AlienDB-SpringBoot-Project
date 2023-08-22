package com.example.bootjpa.controller;

import com.example.bootjpa.dao.AlienRepo;
import com.example.bootjpa.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class AlienController {

    @Autowired
    AlienRepo repo;

    @RequestMapping("/")
    public String home()
    {
        return "home.jsp";
    }

//    @RequestMapping("/addAlien")
//    public String addAlien(Alien alien)
//    {
//        repo.save(alien);
//        return "home.jsp";
//    }

    @RequestMapping("/getAlien")
    public ModelAndView getAlienById(@RequestParam int aid)
    {
        ModelAndView mv = new ModelAndView("showAlien.jsp");
        Alien alien = repo.findById(aid).orElse(new Alien());
        mv.addObject(alien);


        System.out.println(repo.findByTech("Java"));
        System.out.println(repo.findByAidGreaterThanSorted(101));
        return mv;
    }

    @RequestMapping("/alien/{aid}")
    @ResponseBody
    public Optional<Alien> getAlien(@PathVariable("aid") int aid)
    {
        return repo.findById(aid);
    }

    @RequestMapping("/aliens")
    @ResponseBody
    public List<Alien> getAliens()
    {
        return repo.findAll();
    }

    @PostMapping("/alien")
    public Alien addAlien(Alien alien)
    {
        repo.save(alien);
        return alien;
    }

}
