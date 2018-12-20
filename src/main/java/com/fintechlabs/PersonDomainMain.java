package com.fintechlabs;

import com.fintechlabs.model.PersonDomainHazel;
import com.fintechlabs.util.HibernateUtil;
import org.hibernate.Session;

public class PersonDomainMain {

    public static void main(String[] args) {
        PersonDomainMain personDomainMain = new PersonDomainMain();
        personDomainMain.savePerson();
    }

    private void savePerson() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        for (int i = 1; i <= 20000; i++) {
            PersonDomainHazel personDomainHazel = new PersonDomainHazel();
            personDomainHazel.setFirstName("Test");
            personDomainHazel.setLastName("Person #" + i);
            personDomainHazel.setEmailAddress("person" + i + "@email.com");
            personDomainHazel.setPhoneNumber("1928374650");
            session.save(personDomainHazel);
            System.out.println("**************      Inserting Record    ===>>>      Person #" + i);
        }
        session.getTransaction().commit();
        session.flush();
        session.close();
    }

}
