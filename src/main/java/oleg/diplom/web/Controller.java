package oleg.diplom.web;

import oleg.diplom.biz.TaskService;
import oleg.diplom.entity.Customer;
import oleg.diplom.entity.CustomerRepository;
import oleg.diplom.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by user1 on 07.04.2016.
 */
@RestController
public class Controller {

    private final CustomerRepository customerRepository;
    private final TaskService taskService;

    @Autowired
    public Controller(CustomerRepository customerRepository, TaskService taskService) {
        this.customerRepository = customerRepository;
        this.taskService = taskService;
    }

    @RequestMapping("/test2")
    Task test2(){
        return taskService.createTask(new Task());
    }

    @RequestMapping("/test")
    String test(){
        Iterable<Customer> customersIt = customerRepository.findAll();
        Collection<Customer> customers = makeCollection(customersIt);

        Customer customer = new Customer();
        customer.setName("test."+customers.size());
        customerRepository.save(customer);
        customers.add(customer);
        StringBuilder stringBuilder = new StringBuilder();
        for(Customer c : customers){
            stringBuilder.append(c.getId()).append(" ").append(c.getName()).append("</br>");
        }
        return stringBuilder.toString();
    }

    @RequestMapping(path = "/customers", method = RequestMethod.GET)
    public Collection<Customer> readCustomers() {
        return makeCollection(customerRepository.findAll());
    }

    @RequestMapping("/customers/{customerId}")
    public Customer readCustomer(@PathVariable String customerId){
        return customerRepository.findById(Long.valueOf(customerId));
    }


    public static <E> Collection<E> makeCollection(Iterable<E> iter) {
        Collection<E> list = new ArrayList<E>();
        for (E item : iter) {
            list.add(item);
        }
        return list;
    }
}
