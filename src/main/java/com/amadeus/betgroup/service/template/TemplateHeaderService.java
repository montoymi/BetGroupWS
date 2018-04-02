package com.amadeus.betgroup.service.template;

import com.amadeus.betgroup.dao.template.TemplateHeaderDAO;
import com.amadeus.betgroup.model.template.TemplateHeader;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;

import java.util.List;

public class TemplateHeaderService {
    private TemplateHeaderDAO templateHeaderDAO = new TemplateHeaderDAO(MyBatisSqlSession.getSqlSessionFactory());


    public List<TemplateHeader> getAllTemplateHeaderList() {
        List<TemplateHeader> templateHeaderList = templateHeaderDAO.getAllTemplateHeaderList();
        return templateHeaderList;
    }
}
