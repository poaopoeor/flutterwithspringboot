package com.example.flutterwithspringboot.items;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("nyiko/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ItemController {

    private ItemDataAccessService itemDataAccessService;

    public ItemController(ItemDataAccessService itemDataAccessService) {
        this.itemDataAccessService = itemDataAccessService;
    }

    // Inserting data to database;
    @PostMapping(path = "add")
    public void addNewItem(@Valid @RequestBody Item item) {
        itemDataAccessService.insertItems(item);
    }

    //Update data
    @PutMapping(path = "{medical_id}")
    public void updateBook(@PathVariable("medical_id") String medical_id, @RequestBody  Item item) {
        itemDataAccessService.updateItems(medical_id, item);
    }

    // Delete data
    @DeleteMapping(path = "{medical_id}")
    public void deleteBook(@PathVariable("medical_id") String medical_id) {
        itemDataAccessService.deleteItem(medical_id);
    }

    // Select one data
    @GetMapping(path = "{medical_id}")
    public Item getOneItem(@PathVariable("medical_id") String medical_id) {
        return itemDataAccessService.getOneItem(medical_id).orElse(null);
    }

    // Select all data from database;
    @GetMapping(path = "list")
    public List<Item> getAllItems() {
        return itemDataAccessService.selectAllItems();
    }
    
}
