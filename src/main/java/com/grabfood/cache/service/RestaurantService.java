package com.grabfood.cache.service;

import com.grabfood.cache.model.MenuItem;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {

    @Cacheable(value = "restaurantMenu", key = "#id")
    public List<MenuItem> getMenuByRestaurantId(Long id) {
        System.out.println("Truy vấn DB để lấy thực đơn cho nhà hàng: " + id);
        try {
            Thread.sleep(3000); // Giả lập truy vấn chậm
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<MenuItem> menu = new ArrayList<>();
        if (id == 101L) {
            menu.add(new MenuItem(1L, 101L, "Phở Bò", 55000.0));
            menu.add(new MenuItem(2L, 101L, "Bún Chả", 60000.0));
        }
        
        return menu;
    }
}
