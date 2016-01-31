/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glassfish.samples;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.glassfish.samples.entities.Customer;

/**
 *
 * @author arun
 */
@Stateless
@Named
@Path("/customers")
public class CustomerSessionBean {
    
    @PersistenceContext EntityManager em;
    
    @Inject NameSuggestion name;
    
    public List<Customer> getCustomers() {
        return (List<Customer>)em.createNamedQuery("Customer.findAll").getResultList();
    }

    // Can this be CriteriaQuery ??
    public void getCustomerSuggestion() {
        List<Customer> list = (List<Customer>)em.
                createNamedQuery("Customer.findSuggestion").
                setParameter("name", name.getHint()).
                getResultList();
        
        name.setSuggestions(list);
        
        System.out.println("Got list: " + list);
    }
    
    @GET
    @Path("/customer/{id}")
    @Produces("application/xml")
    public Customer getCustomer(@PathParam("id")Integer id) {
        Customer customer = (Customer)em.createNamedQuery("Customer.findByCustomerId").setParameter("customerId", id).getSingleResult();
        
        return customer;
    }
    
    public void createCustomer() {
        
    }
}
