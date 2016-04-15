package com.office.spring.service;

import com.office.spring.dao.TeamDao;
import com.office.spring.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by totient on 11/12/15.
 */
@Service("teamService")
@Transactional
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamDao teamDao;
    @Override
    public void saveTeam(Team team) {
        teamDao.saveTeam(team);
    }


    public void deleteTeamByName(String id) {
        teamDao.deleteTeam(teamDao.getTeamByName(id));
    }
}
