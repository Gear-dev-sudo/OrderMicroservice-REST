package com.Zyfi.ProductMicroservice.RESTController;

import com.Zyfi.ProductMicroservice.DAO.OrderDAO;
import com.Zyfi.ProductMicroservice.entity.Order;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderRestController {
    private OrderDAO orderDAO;

    //inject (temp)
    public OrderRestController(@Qualifier("orderDAOImpl") OrderDAO theOrderDAO)
    {
        orderDAO=theOrderDAO;
    }

    //expose '/orders'
    @GetMapping("/orders")
    public List<Order> findAll(){
        return orderDAO.findAll();
    }

    @GetMapping("/ordersPG")
    public Page<Order> findAll(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "1") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return orderDAO.findAll(pageRequest);
    }

}
