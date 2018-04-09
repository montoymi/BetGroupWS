package com.amadeus.betgroup.dao.tournament;

import com.amadeus.betgroup.model.tournament.Group;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class GroupDAO {
    private SqlSessionFactory sqlSessionFactory;

    public GroupDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public void createGroup(Group group) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.insert("Group.insertGroup", group);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updateGroup(Group group) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.update("Group.updateGroup", group);
            session.commit();
        } finally {
            session.close();
        }
    }

    public Group getGroupById(int idGroup) {
        Group group;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            group = session.selectOne("Group.selectGroupById", idGroup);
        } finally {
            session.close();
        }
        return group;
    }

    public List<Group> getAllGroupsByPhaseId(int phaseId) {
        List<Group> groupList;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            groupList = session.selectList("Group.selectGroupByPhaseId", phaseId);
        } finally {
            session.close();
        }
        return groupList;
    }
}
