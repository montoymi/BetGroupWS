package com.amadeus.betgroup.dao.account;

import com.amadeus.betgroup.model.config.NotificationTemplate;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserNotificationDAO {
    private SqlSessionFactory sqlSessionFactory;

    public UserNotificationDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public void createNotificationTemplate(NotificationTemplate notificationTemplate) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.insert("NotificationTemplates.insert", notificationTemplate);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updateNotificationTemplate(NotificationTemplate notificationTemplate) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.update("NotificationTemplates.update", notificationTemplate);
            session.commit();
        } finally {
            session.close();
        }
    }

    public NotificationTemplate getNotificationTemplateById(int id) {
        NotificationTemplate person;

        SqlSession session = sqlSessionFactory.openSession();

        try {
            person = session.selectOne("NotificationTemplates.selectById", id);
        } finally {
            session.close();
        }

        return person;
    }
}
