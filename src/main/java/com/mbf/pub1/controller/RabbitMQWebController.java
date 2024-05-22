package com.mbf.pub1.controller;

import com.mbf.pub1.entity.Employee;
import com.mbf.pub1.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/javainuse-rabbitmq/")
public class RabbitMQWebController {

  @Autowired
  RabbitMQSender rabbitMQSender;

//  @GetMapping(value = "/producer")
//  public String producer(@RequestParam("empName") String empName, @RequestParam("empId") String empId) {
//
//    Employee emp=new Employee();
//    emp.setEmpId(empId);
//    emp.setEmpName(empName);
//    rabbitMQSender.send(emp);
//
//    return "Message sent to the RabbitMQ JavaInUse Successfully";
//  }

  @PostMapping("/producer")
  public String producer(@RequestBody Employee employee){
    rabbitMQSender.send(employee);
    return "Message sent to the RabbitMQ JavaInUse Successfully";
  }
}
