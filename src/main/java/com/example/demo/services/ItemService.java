package com.example.demo.services;

import com.example.demo.models.Item;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    
    private List<Item> items = new ArrayList<>();
    
    public ItemService() {
        // Add sample data
        items.add(new Item("Sample Item"));
    }
    
    public List<Item> getAllItems() {
        return items;
    }
    
    public void addItem(Item item) {
        items.add(item);
    }
}