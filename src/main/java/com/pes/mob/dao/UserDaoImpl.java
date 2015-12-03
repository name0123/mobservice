package com.pes.mob.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pes.mob.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<String, User> implements UserDao {
	
    public User findById(String user_id) {
        return getByKey(user_id);
    }
 
    public void saveUser(User user) {
        persist(user);
    }
 
    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
    }
    
    @SuppressWarnings("unchecked")
	public User findByUserN(String userN) {
		List<User> users = getSession().createCriteria(User.class)
				.add(Restrictions.like("userN", userN, MatchMode.EXACT))
				.list();
		if (users.isEmpty()) return null;
		return users.get(0);
	}
}
