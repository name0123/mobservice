package com.pes.mob.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.pes.mob.dao.AbstractDao;
import com.pes.mob.dao.UserDao;
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

}
