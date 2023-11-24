package com.Zyfi.ProductMicroservice.Service;

import com.Zyfi.ProductMicroservice.entity.Order;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrderService {

    List<Order> findAll();
    Page<Order> findAllWithPg(PageRequest pageRequest);

    Order findById(int theId);

    @Transactional
    Order save(Order theOrder);

    @Transactional
    void deleteById(int theId);

    @Transactional
    boolean authorizeById(int theId,int authorisedPersonId);
}
