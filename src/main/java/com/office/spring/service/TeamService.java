package com.office.spring.service;

import com.office.spring.model.Team;

/**
 * Created by totient on 11/12/15.
 */
public interface TeamService {
    public void saveTeam(Team team);
    public void deleteTeamByName(String name);
}
