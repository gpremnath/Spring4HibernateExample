package com.office.spring.service;

/**
 * Created by premnath on 17/4/16.
 */
import com.office.spring.dao.GroupDao;
import com.office.spring.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by premnath on 29/11/15.
 */
@Service("groupService")
@Transactional
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupDao groupDao;
    public Group findById(Long id) {
        return groupDao.findById(id);
    }

    public void saveGroup(Group group) {
        groupDao.saveGroup(group);
    }

    public void deleteGroup(Group group) {
        groupDao.deleteGroup(group);
    }

    public List<Group> listAllGroups() {
        return groupDao.lisAllGroups();
    }
}
