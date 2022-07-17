package com.wisdomtech.tmds.controllers.apis;

import com.wisdomtech.tmds.models.Garage;
import com.wisdomtech.tmds.services.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/garages")
public class GarageController {


   @Autowired
    private GarageService garageService;

    public Model addModelAttributes(Model model)
    {
        model.addAttribute("garage", garageService.findAll());
        return model;
    }

    //Get All Records
    @GetMapping("/garage_index")
    public String findAll(Model model)
    {
        addModelAttributes(model);
        return "/garage/garage_index";
    }

    @GetMapping("/garageAdd")
    public String addGarage(Model model)
    {
        model.addAttribute("garage", garageService.findAll());
        return "/garageAdd";
    }

    @GetMapping("garage/garage/{op}/{id}")
    public String editGarage(@PathVariable Integer id, @PathVariable String op, Model model)
    {
        addModelAttributes(model);
        model.addAttribute("garage", garageService.findById(id));
        return "garage/garage" +op;
    }

    //Add Location
    @PostMapping("/garage")
    public String addNew(Garage garage)
    {
        garageService.save(garage);
        return "redirect:/garage_index";
    }

    @RequestMapping(value ="garage/garage_index/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(@PathVariable Integer id) {
        garageService.delete(id);
        return "redirect:garage_index";
    }

    /*@PostMapping(value = "/")
    public ResponseEntity<Garage> save(@RequestBody Garage garage){
        Garage save = garageService.save(garage);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @GetMapping("/garage")
    public List<Garage> findAll(){
        return garageService.findAll();
    }

    @GetMapping("/garage/{id}")
    public Optional<Garage> findById(@PathVariable("id") Long id){
        return garageService.findById(id);
    }

    @DeleteMapping("/garage/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        garageService.deleteById(id);
    }

    @PutMapping("/garage/{id}")
    public ResponseEntity<Garage> update(@PathVariable("id") Long id, @RequestBody Garage garage){
        Optional<Garage> garageData = garageService.findById(id);
        Garage _garage = new Garage();
        if (garageData.isPresent()){
            _garage = garageData.get();
            _garage.setDescription(garage.getDescription());
            _garage.setAddress(garage.getAddress());
            _garage.setPhone(garage.getPhone());
            _garage.setManagerName(garage.getManagerName());

            return new ResponseEntity<>(garageService.save(_garage), HttpStatus.OK);
        }
        return new ResponseEntity<>(_garage, HttpStatus.EXPECTATION_FAILED);
    }*/
}
