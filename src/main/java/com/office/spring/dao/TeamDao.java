package com.office.spring.dao;

import com.office.spring.model.Team;

/**
 * Created by totient on 11/12/15.
 */

public interface TeamDao {
    void saveTeam (Team team);
    void deleteTeam(Team team);
    Team getTeamByName(String name);
}
