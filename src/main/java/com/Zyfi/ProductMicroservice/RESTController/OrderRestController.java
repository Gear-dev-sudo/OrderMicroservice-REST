package com.Zyfi.ProductMicroservice.RESTController;

import com.Zyfi.ProductMicroservice.ApiResponse;
import com.Zyfi.ProductMicroservice.ResponseStatus;
import com.Zyfi.ProductMicroservice.Service.OrderService;
import com.Zyfi.ProductMicroservice.entity.Order;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
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
    public ApiResponse findAll(){
        List<Order> orders=orderService.findAll();
        ApiResponse response=new ApiResponse();
        if(orders.size()==0) {
            response.setFlag(ResponseStatus.GET_FAILED);
        }
        else
        {
            response.setFlag(ResponseStatus.GET_SUCCESS);
            response.setData(orders);
        }

        return response;
    }



    @GetMapping("/ordersPG")
    public ApiResponse findAllWithPg(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "1") int size) {
        ApiResponse response = new ApiResponse();

        try {
            Page<Order> ordersPage = orderService.findAllWithPg(PageRequest.of(page, size));

            if (ordersPage.isEmpty()) {
                response.setFlag(ResponseStatus.GET_FAILED);
            } else {
                response.setFlag(ResponseStatus.GET_SUCCESS);
                response.setData(ordersPage);
            }
        } catch (Exception e) {
            response.setFlag(ResponseStatus.GET_FAILED);
        }

        return response;
    }

    @GetMapping("/orders/{orderId}")
    public ApiResponse findOrder(@PathVariable int orderId) {
        ApiResponse response = new ApiResponse();
            Order theOrder = orderService.findById(orderId);

            if (theOrder == null) {
                response.setFlag(ResponseStatus.GET_FAILED);

            } else {
                response.setFlag(ResponseStatus.GET_SUCCESS);
            }
            response.setData(theOrder);
        return response;
    }


    //add mapping for GET /orders/{orderId}
    @PostMapping("/orders")
    public ApiResponse addOrder(@RequestBody Order theOrder) {
        ApiResponse response = new ApiResponse();

        try {
            // Set id to 0 to force save of a new item
            theOrder.setOrderId(0L);
            // Inject current time
            theOrder.setCreationTime(java.sql.Timestamp.valueOf(LocalDateTime.now()));

            Order dbOrder = orderService.save(theOrder);

            response.setFlag(ResponseStatus.POST_SUCCESS);
            response.setData(dbOrder);
        } catch (Exception e) {
            response.setFlag(ResponseStatus.POST_FAILED);
        }

        return response;
    }

    @PutMapping("/orders/{orderId}")
    public ApiResponse updateOrder(@PathVariable int orderId, @RequestBody Order updatedOrder) {
        ApiResponse response = new ApiResponse();

        try {
            // Check if the order with the given ID exists
            Order existingOrder = orderService.findById(orderId);

            if (existingOrder == null) {
                response.setFlag(ResponseStatus.UPDATE_FAILED);
            } else {
                // Update all properties of the existing order with values from the updated order
                // Assuming Order has appropriate getter and setter methods
                BeanUtils.copyProperties(updatedOrder, existingOrder);
                System.out.println(existingOrder);
                // Save the updated order
                Order dbOrder = orderService.save(existingOrder);

                response.setFlag(ResponseStatus.UPDATE_SUCCESS);
                response.setData(dbOrder);
            }
        } catch (Exception e) {
            response.setFlag(ResponseStatus.UPDATE_FAILED);
        }

        return response;
    }


    @PutMapping("/orders/authorize/{orderId}/{authPersonId}")
    public ApiResponse authorizeOrder(@PathVariable int orderId, @PathVariable int authPersonId) {
        ApiResponse response = new ApiResponse();

        try {
            Boolean result = orderService.authorizeById(orderId, authPersonId);

            response.setFlag(ResponseStatus.UPDATE_SUCCESS);
            response.setData(result);
        } catch (Exception e) {
            response.setFlag(ResponseStatus.UPDATE_FAILED);
        }

        return response;
    }

    @PutMapping("/orders/finish/{orderId}/{finishedPersonId}")
    public ApiResponse finishOrder(@PathVariable int orderId, @PathVariable int finishedPersonId) {
        ApiResponse response = new ApiResponse();

        try {
            Boolean result = orderService.finishById(orderId, finishedPersonId);

            response.setFlag(ResponseStatus.UPDATE_SUCCESS);
            response.setData(result);
        } catch (Exception e) {
            response.setFlag(ResponseStatus.UPDATE_FAILED);

        }

        return response;
    }

    @DeleteMapping("/orders/{orderId}")
    public ApiResponse deleteOrder(@PathVariable int orderId) {
        ApiResponse response = new ApiResponse();

        try {
            Order theOrder = orderService.findById(orderId);

            if (theOrder == null) {
                response.setFlag(ResponseStatus.DELETE_FAILED);

            } else {
                response.setData(theOrder);
                orderService.deleteById(orderId);
                response.setFlag(ResponseStatus.DELETE_SUCCESS);

            }
        } catch (Exception e) {
            response.setFlag(ResponseStatus.DELETE_FAILED);
        }

        return response;
    }
}
