package com.office.spring.dao;

/**
 * Created by premnath on 17/4/16.
 */
import com.office.spring.model.Group;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by premnath on 29/11/15.
 */
@Repository("groupDao")
public class GroupDaoImpl extends AbstractDao<Long,Group> implements GroupDao {
    public Group findById(Long id) {
        return findById(id);
    }

    public void saveGroup(Group group) {
        persist(group);

    }

    public void deleteGroup(Group group) {
        delete(group);
    }

    public List<Group> lisAllGroups() {
        Criteria criteria=getSession().createCriteria(Group.class);
        return (List<Group>)criteria.list();
    }
}
