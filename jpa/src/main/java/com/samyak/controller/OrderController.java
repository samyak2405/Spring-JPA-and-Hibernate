package com.samyak.controller;

import com.samyak.entity.Order;
import jakarta.ws.rs.Path;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.samyak.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<Order> saveOrderDetails(@RequestBody Order order){
        Order savedOrder = orderService.saveOrderDetails(order);
        return new ResponseEntity<Order>(savedOrder, HttpStatus.CREATED);
    }
    @PostMapping("/save-all")
    public ResponseEntity<List<Order>> saveOrderDetails(@RequestBody List<Order> orders){
        List<Order> savedOrders = orderService.saveAllOrderDetails(orders);
        return new ResponseEntity<List<Order>>(savedOrders, HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<List<Order>>(orders,HttpStatus.OK);
    }

    @GetMapping("/get-by-tracking-id/{order-tracking-number}")
    public ResponseEntity<Order> getOrderByTrackingId(@PathVariable("order-tracking-number")String orderTrackingNumber){
        Order order = orderService.findByOrderTrackingNumber(orderTrackingNumber);
        return new ResponseEntity<Order>(order,HttpStatus.OK);
    }

    @PutMapping("/update/{order-tracking-number}")
    public ResponseEntity<?> updateOrderDetails(@PathVariable("order-tracking-number")String orderTrackingNumber,@RequestBody Order order){
        if(orderService.findByOrderTrackingNumber(orderTrackingNumber)==null)
            return new ResponseEntity<String>("Order does not exist",HttpStatus.NOT_FOUND);
        Order updatedOrder = orderService.updateOrderDetails(orderTrackingNumber,order);
        return new ResponseEntity<Order>(updatedOrder,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{order-tracking-number}")
    public ResponseEntity<?> deleteOrder(@PathVariable("order-tracking-number")String orderTrackingNumber){
        if(orderService.findByOrderTrackingNumber(orderTrackingNumber)==null)
            return new ResponseEntity<String>("Order does not exist",HttpStatus.NOT_FOUND);
        orderService.deleteOrder(orderTrackingNumber);
        return new ResponseEntity<String>("Order with tracking id: "+orderTrackingNumber+" deleted",HttpStatus.OK);
    }
}
