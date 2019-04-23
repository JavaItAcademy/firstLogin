package it.academy.firstLogin.controller;

import it.academy.firstLogin.model.Item;
import it.academy.firstLogin.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/api/items")
    public List<Item> getItems() {
        return itemService.getAllItems();
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/api/addItem",consumes = {"application/json"},produces = {"application/json"})
    @ResponseBody
    public Item addItem(@RequestBody Item item) {
        itemService.addItem(item);
        return item;
    }

    @DeleteMapping(value = "api/deleteItem/{id}")
    @ResponseBody
    public String deleteItem(@PathVariable int id) {
        itemService.deleteItem(id);
        return "Deleted";
    }
}
