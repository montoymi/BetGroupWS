package com.amadeus.betgroup.service.tournament;

import com.amadeus.betgroup.dao.tournament.GroupDAO;
import com.amadeus.betgroup.model.tournament.Group;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;

import java.util.List;

public class GroupService {
    private GroupDAO groupDAO = new GroupDAO(MyBatisSqlSession.getSqlSessionFactory());

    public List<Group> getAllGroupsByPhaseId(int phaseId){
        List<Group> groupList = groupDAO.getAllGroupsByPhaseId(phaseId);
        return groupList;
    }
}
