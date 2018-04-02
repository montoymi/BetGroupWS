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

    public List<TemplateHeader> getAllTemplateHeaderList(){
        SqlSession session = sqlSessionFactory.openSession();
        List<TemplateHeader> templateHeaderList;
        try {
            templateHeaderList =session.selectList("TemplateHeaders.getAllTemplateHeaderList");
            session.commit();

        } finally {
            session.close();
        }
        return templateHeaderList;
    }
}
