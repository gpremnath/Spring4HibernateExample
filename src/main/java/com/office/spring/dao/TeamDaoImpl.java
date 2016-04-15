package com.office.spring.dao;

import com.office.spring.model.Team;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by totient on 11/12/15.
 */

@Repository("teamDao")
public class TeamDaoImpl extends AbstractDao<Integer,Team> implements TeamDao {
    @Override
    public void saveTeam(Team team) {
     persist(team);
    }

    @Override
    public void deleteTeam(Team team) {
      delete(team);
    }

    @Override
    public Team getTeamByName(String name) {
        Criteria criteria =  createEntityCriteria();//getSession().createCriteria(Team.class);
        criteria.add(Restrictions.eq("name", name));
        return (Team) criteria.uniqueResult();

    }


}
