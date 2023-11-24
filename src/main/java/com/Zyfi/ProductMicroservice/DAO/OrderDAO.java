
package com.Zyfi.ProductMicroservice.DAO;

import com.Zyfi.ProductMicroservice.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDAO extends JpaRepository<Order, Long> {

    // You can add custom queries or methods here if needed

    Order findById(int theId);



    // Example of custom method for finding all orders with pagination
    public List<Order> findAll();

    void deleteById(int theId);

    Page<Order> findAllWithPagination(PageRequest pageRequest);
}
