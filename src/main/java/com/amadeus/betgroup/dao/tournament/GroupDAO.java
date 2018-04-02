package com.amadeus.betgroup.dao.tournament;

import com.amadeus.betgroup.model.tournament.Group;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class GroupDAO {
    private SqlSessionFactory sqlSessionFactory;

    public GroupDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public void createGroup(Group group) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.insert("Group.insert", group);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updateGroup(Group group) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.update("Group.update", group);
            session.commit();
        } finally {
            session.close();
        }
    }

    public Group getGroupById(int id) {
        Group group;

        SqlSession session = sqlSessionFactory.openSession();

        try {
            group = session.selectOne("Group.selectById", id);
        } finally {
            session.close();
        }

        return group;
    }
}
