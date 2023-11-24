package com.Zyfi.ProductMicroservice.RESTController;

import com.Zyfi.ProductMicroservice.DAO.OrderDAO;
import com.Zyfi.ProductMicroservice.Service.OrderService;
import com.Zyfi.ProductMicroservice.entity.Order;

import lombok.experimental.PackagePrivate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class OrderRestController {
    private OrderService orderService;

    @Autowired
    public OrderRestController(OrderService theOrderService)
    {
        orderService=theOrderService;
    }

    //expose '/orders'
    @GetMapping("/orders")
    public List<Order> findAll(){
        return orderService.findAll();
    }

    @GetMapping("/ordersPG")
    public Page<Order> findAllWithPg(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "1") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return orderService.findAllWithPg(pageRequest);
    }

    //add mapping for GET /orders/{orderId}
    @GetMapping("/orders/{orderId}")
    public Order getOrder(@PathVariable int orderId) {
        Order theOrder = orderService.findById(orderId);

        if (theOrder == null)
        {
            throw new RuntimeException("Order id Not FOUND");
        }
        return theOrder;
    }

    //add mapping for POST( add a new order)
    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order theOrder)
    {
        //also,just in case they pass in an id in JSON ... set id to 0
        //this is to force a save of new item ... instead of Update
        theOrder.setOrderId(0L);
        //inject current time
        theOrder.setCreationTime( java.sql.Timestamp.valueOf(LocalDateTime.now()) );
        Order dbOrder=orderService.save(theOrder);

        return dbOrder;
     }

     //add mapping for PUT(Update an order)
    @PutMapping("/orders")
    public Order updateOrder(@RequestBody Order theOrder)
    {
        Order dbOrder=orderService.save(theOrder);
        return dbOrder;
    }

    //add mapping for Deletion
    @DeleteMapping("/orders/{orderId}")
    public String deleteOrder(@PathVariable int orderId) {
        Order theOrder=orderService.findById(orderId);
        // throw Exception if null

        if(theOrder == null)
            throw  new RuntimeException("Order id not found");
        orderService.deleteById(orderId);

        return "Deleted order id - "+ orderId;
    }
}
