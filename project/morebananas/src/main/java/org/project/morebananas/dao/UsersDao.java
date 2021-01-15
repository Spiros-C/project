package org.project.morebananas.dao;

import java.util.Collection;
import java.util.List;
import org.project.morebananas.entities.Users;
import org.project.morebananas.dao.IUsersDao;
import org.springframework.stereotype.Repository;

//abstract class
@Repository("IUsersDao")
public abstract class UsersDao extends AbstractDao<Integer, Users> implements IUsersDao{    
	//An alternative to Hibernate.initialize()
	protected void initializeCollection(Collection<?> collection) {
	    if(collection == null) {
	        return;
	    }
	    collection.iterator().hasNext();
	}
//    @Override
//    public Users findById(int userId) {
//        Users user = getByKey(userId);
//        if (user != null){
//            return user;
//        }
//        return null;
//    }
    
        @Override
    	public Users findById(int userId) {
		Users user = getByKey(userId);
		if(user!=null){
			initializeCollection(user.getUserProfiles());
		}
		return user; //null
	}

    @Override
    public List<Users> findAllUsers() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
//      public List<Customer> findAllUsers() {
//         Criteria criteria = createEntityCriteria();
//         //return((List<Users>)criteria.list());
//         return(criteria.list());
//                 
//    }
    
    
    
    
    

    @Override
    public void save(Users user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteByUserId(int userId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    




}
