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
            session.insert("NotificationTemplates.insertNotificationTemplate", notificationTemplate);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updateNotificationTemplate(NotificationTemplate notificationTemplate) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.update("NotificationTemplates.updateNotificationTemplateByCode", notificationTemplate);
            session.commit();
        } finally {
            session.close();
        }
    }

    public NotificationTemplate getNotificationTemplateById(String notificationCode) {
        NotificationTemplate person;

        SqlSession session = sqlSessionFactory.openSession();

        try {
            person = session.selectOne("NotificationTemplates.selectNotificationTemplateByCode", notificationCode);
        } finally {
            session.close();
        }

        return person;
    }
}
