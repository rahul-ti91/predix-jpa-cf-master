package com.rahul.msr.data.jpa.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rahul.msr.data.jpa.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
@SuppressWarnings("unchecked")
@Transactional
public class CORESMSRService {

    public static final String CUSTOMERS = "customers";

    @PersistenceContext
    private EntityManager em;

    public Customer createCustomer(String name, String phone, Date timeStamp) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setPhone(phone);
        customer.setTStamp(timeStamp);
        em.persist(customer);
        return customer;
    }

    public Collection<Customer> search(String name) {
        String sqlName = ("%" + name + "%").toLowerCase();
        String sql = "select c.* from customer c where (LOWER( c.name ) LIKE :fn)";
        return em.createNativeQuery(sql, Customer.class)
                .setParameter("fn", sqlName)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public List<Customer> getAllCustomers() {
        return em.createQuery("FROM Customer").getResultList();
    }

    @Cacheable(CUSTOMERS)
    @Transactional(readOnly = true)
    public Customer getCustomerById(Integer id) {
        return em.find(Customer.class, id);
    }

    @CacheEvict(CUSTOMERS)
    public void deleteCustomer(Integer id) {
        Customer customer = getCustomerById(id);
        em.remove(customer);
    }

    @CachePut(value = CUSTOMERS, key = "#id")
    public void updateCustomer(Integer id, String name, String phone, Date date) {
        Customer customer = getCustomerById(id);
        customer.setTStamp(date);
        customer.setName(name);
        customer.setPhone(phone);
        em.merge(customer);
    }
    
    public Applications createApplication(String applicationName){
    	Applications application = new Applications();
    	application.setApplicationName(applicationName);
    	return application;
    }
    
    @Transactional(readOnly = true)
    public List<Applications> getApplications(){
    	return em.createQuery("from Applications").getResultList();
    }
    
    public Appreciations createAppreciation(String applicationName, BigInteger applicationId, String appreciation){
    	Appreciations appreciation1 = new Appreciations();
    	appreciation1.setApplicationName(applicationName);
    	appreciation1.setAppreciation(appreciation);
    	appreciation1.setApplicationId(applicationId);
    	appreciation1.setCreationDate(new Date());
    	return appreciation1;
    }
    
    @Transactional(readOnly = true)
    public List<Appreciations> getAppreciations(){
    	return em.createQuery("from Appreciations").getResultList();
    }
    
    public CloseActivity createCloseActivity(Date activityDate, BigInteger applicationId, String applicationName, String description, String frequency){
    	CloseActivity closeActivity = new CloseActivity();
    	closeActivity.setActivityDate(activityDate);
    	closeActivity.setApplicationId(applicationId);
    	closeActivity.setApplicationName(applicationName);
    	closeActivity.setCreatedDate(new Date());
    	closeActivity.setDescription(description);
    	closeActivity.setFrequency(frequency);
    	return closeActivity;
    }
    
    public List<CloseActivity> getCloseActivities(){
    	return em.createQuery("from CloseActivity").getResultList();
    }
    
    public CORESIssues createIssue(BigInteger applicationId, String applicationName, String issue){
    	CORESIssues coresIssues = new CORESIssues();
    	coresIssues.setApplicationId(applicationId);
    	coresIssues.setApplicationName(applicationName);
    	coresIssues.setCreatedDate(new Date());
    	coresIssues.setIssue(issue);
    	return coresIssues;
    } 

    public List<CORESIssues> getIssues(){
    	return em.createQuery("from CORESIssues").getResultList();
    }
    
    public DRCalendar createDRCalendar(BigInteger applicationId, String applicationName, Date drCompletionDate, Date upcomingDRDate){
    	DRCalendar calendar = new DRCalendar();
    	calendar.setApplicationId(applicationId);
    	calendar.setApplicationName(applicationName);
    	calendar.setCreationDate(new Date());
    	calendar.setDrCompletionDate(drCompletionDate);
    	calendar.setUpcomingDRDate(upcomingDRDate);
    	return calendar;
    }

    public List<DRCalendar> getDRCalendar(){
    	return em.createQuery("from DRCalendar").getResultList();
    }
    
    public Ideas createIdeas(BigInteger applicationId, String applicationName, String businessBenefits, String ideaDescription, String ideaState, String implamentationPlan){
    	Ideas ideas = new Ideas();
    	ideas.setApplicationId(applicationId);
    	ideas.setApplicationName(applicationName);
    	ideas.setBusinessBenefits(businessBenefits);
    	ideas.setCreationDate(new Date());
    	ideas.setIdeaDescription(ideaDescription);
    	ideas.setIdeaState(ideaState);
    	ideas.setImplamentationPlan(implamentationPlan);
    	return ideas;
    }

    public List<Ideas> getIdeas(){
    	return em.createQuery("from Ideas").getResultList();
    }
    
    public LeaveCalendar createLeaveCalendar(BigInteger applicationId, String applicationName, String backup, String leaveType, Date leaveEndDate, Date leaveStartDate){
    	LeaveCalendar calendar = new LeaveCalendar();
    	calendar.setApplicationId(applicationId);
    	calendar.setApplicationName(applicationName);
    	calendar.setBackup(backup);
    	calendar.setCreationDate(new Date());
    	calendar.setLeaveEndDate(leaveEndDate);
    	calendar.setLeaveStartDate(leaveStartDate);
    	calendar.setLeaveType(leaveType);
    	return calendar;
    }
    
    public List<LeaveCalendar> getLeaveCalendar(){
    	return em.createQuery("from LeaveCalendar").getResultList();
    }
    
    public NONSNData createNONSNData(BigInteger applicationId, String applicationName, String nonsndata, String week){
    	NONSNData data = new NONSNData();
    	data.setApplicationId(applicationId);
    	data.setApplicationName(applicationName);
    	data.setCreationDate(new Date());
    	data.setData(nonsndata);
    	data.setWeek(week);
    	return data;
    }
    
    public List<NONSNData> getNONSNData(){
    	return em.createQuery("from NONSNData").getResultList();
    }

    public Outages createOutage(BigInteger applicationId, String applicationName, String duration, boolean rcaDone, String outageType, Date outageDate, String outageReason, String startTime){
    	Outages outages = new Outages();
    	outages.setApplicationId(applicationId);
    	outages.setApplicationName(applicationName);
    	outages.setCreatedDate(new Date());
    	outages.setDuration(duration);
    	outages.setOutageDate(outageDate);
    	outages.setOutageReason(outageReason);
    	outages.setOutageType(outageType);
    	outages.setRcaDone(rcaDone);
    	outages.setStartTime(startTime);
    	return outages;
    }
    
    public List<Outages> getOutages(){
    	return em.createQuery("from Outages").getResultList();
    }
}
