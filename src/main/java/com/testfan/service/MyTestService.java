package com.testfan.service;

import org.springframework.stereotype.Service;

import com.testfan.model.CaseSystem;
import com.testfan.model.CaseSystemCriteria;

@Service
public class MyTestService extends BaseService<CaseSystem>{

	@Override
	public Object getPageCriteria() {
		CaseSystemCriteria caseSystemCriteria =new CaseSystemCriteria();
		return caseSystemCriteria;
	}

}
