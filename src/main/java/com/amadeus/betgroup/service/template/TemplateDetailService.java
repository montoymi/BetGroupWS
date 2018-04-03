package com.amadeus.betgroup.service.template;

import com.amadeus.betgroup.dao.template.TemplateDetailDAO;
import com.amadeus.betgroup.model.template.TemplateDetail;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;

import java.util.List;

public class TemplateDetailService {
    private TemplateDetailDAO templateDetailDAO = new TemplateDetailDAO(MyBatisSqlSession.getSqlSessionFactory());


    public List<TemplateDetail> getTemplateDetailsByTempHeader( int template_header_id) {
        List<TemplateDetail> templateDetailList = templateDetailDAO.getTemplateDetailsByTempHeader(template_header_id);
        return templateDetailList;
    }

}
