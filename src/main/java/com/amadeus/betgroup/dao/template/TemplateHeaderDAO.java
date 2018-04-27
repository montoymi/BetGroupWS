package com.amadeus.betgroup.dao.template;

import com.amadeus.betgroup.model.template.TemplateHeader;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class TemplateHeaderDAO {
    private SqlSessionFactory sqlSessionFactory;

    public TemplateHeaderDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<TemplateHeader> getAllActiveTemplateHeaderList(){
        SqlSession session = sqlSessionFactory.openSession();
        List<TemplateHeader> templateHeaderList;
        try {
            templateHeaderList =session.selectList("TemplateHeaders.getAllActiveTemplateHeaderList");
            session.commit();

        } finally {
            session.close();
        }
        return templateHeaderList;
    }
}
