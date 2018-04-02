package com.amadeus.betgroup.dao.template;

import com.amadeus.betgroup.model.template.TemplateDetail;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class TemplateDetailDAO {

    private SqlSessionFactory sqlSessionFactory;

    public TemplateDetailDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<TemplateDetail> getTemplateDetailsByTempHeader(int template_header_id){
        SqlSession session = sqlSessionFactory.openSession();
        List<TemplateDetail> templateDetailList;
        try {
            templateDetailList =session.selectList("TemplateDetails.getTemplateDetailsByTempHeader", template_header_id);
            session.commit();

        } finally {
            session.close();
        }
        return templateDetailList;
    }
}
