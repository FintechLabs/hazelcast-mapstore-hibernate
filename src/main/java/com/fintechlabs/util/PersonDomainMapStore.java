package com.fintechlabs.util;

import com.fintechlabs.model.PersonDomainHazel;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.MapLoaderLifecycleSupport;
import com.hazelcast.core.MapStore;
import lombok.NoArgsConstructor;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.*;

@NoArgsConstructor
public class PersonDomainMapStore implements MapStore<String, PersonDomainHazel>, MapLoaderLifecycleSupport {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private Session session = sessionFactory.openSession();
    private Query allKeysQuery = session.createQuery("select uniqueId from PersonDomainHazel").setFetchSize(1000);


    @Override
    public void store(String key, PersonDomainHazel value) {

    }

    @Override
    public void storeAll(Map<String, PersonDomainHazel> map) {

    }

    @Override
    public void delete(String key) {

    }

    @Override
    public void deleteAll(Collection<String> keys) {

    }

    @Override
    public PersonDomainHazel load(String key) {
        Criteria criteria = session.createCriteria(PersonDomainHazel.class).add(Restrictions.eq("uniqueId", key));
        return (PersonDomainHazel) criteria.uniqueResult();
    }

    @Override
    public Map<String, PersonDomainHazel> loadAll(Collection<String> keys) {
        Criteria criteria = session.createCriteria(PersonDomainHazel.class).add(Restrictions.in("uniqueId", keys));
        List<PersonDomainHazel> personDomainHazelList = criteria.list();
        Map<String, PersonDomainHazel> personDomainMap = new HashMap<>();
        personDomainHazelList.forEach(personDomainHazel -> personDomainMap.put(personDomainHazel.getUniqueId(), personDomainHazel));
        return personDomainMap;
    }

    @Override
    public Iterable<String> loadAllKeys() {
        return new QueryIterable<>(allKeysQuery);
    }

    @Override
    public void init(HazelcastInstance hazelcastInstance, Properties properties, String mapName) {

    }

    @Override
    public void destroy() {
        session.close();
    }

}
