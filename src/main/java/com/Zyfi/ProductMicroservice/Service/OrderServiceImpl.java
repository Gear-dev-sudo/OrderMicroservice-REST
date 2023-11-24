package com.Zyfi.ProductMicroservice.Service;

import com.Zyfi.ProductMicroservice.DAO.OrderDAO;
import com.Zyfi.ProductMicroservice.entity.Order;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

     private final OrderDAO orderDAO;

     @Autowired
     public OrderServiceImpl(@Qualifier("orderDAOImpl") OrderDAO theOrderDAO){
         orderDAO=theOrderDAO;
     }
    @Override
    public List<Order> findAll() {
        return orderDAO.findAll();
    }
    public Page<Order> findAllWithPg(PageRequest pageRequest) {
        return  orderDAO.findAll(pageRequest);
    }

    @Override
    public Order findById(int theId)
    {
        return  orderDAO.findById(theId);
    }

    @Override
    @Transactional
    public Order save(Order theOrder)
    {
        return orderDAO.save(theOrder);
    }

    @Transactional
    @Override
    public void deleteById(int theId)
    {
        orderDAO.deleteById(theId);
    }

    @Override
    @Transactional
    public boolean authorizeById(int theId, int authorisedPersonId) {
        Order theOrder=orderDAO.findById(theId);
        if(theOrder == null)
        {
            throw  new RuntimeException("Order id not found");
        }

        else if(theOrder.getAuthorised()==true) {
            throw new RuntimeException("Order Already Auth-ed");
        }
        else {
            theOrder.setAuthorised(true);
            theOrder.setAuthorisedTime(java.sql.Timestamp.valueOf(LocalDateTime.now()));
            theOrder.setAuthorisedPersonId((long) authorisedPersonId);
            return true;
        }
    }

}
