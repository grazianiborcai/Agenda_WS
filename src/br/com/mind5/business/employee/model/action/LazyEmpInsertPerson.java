package br.com.mind5.business.employee.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmpInsertPerson extends ActionLazyTemplateV1<EmpInfo, EmpInfo> {
	
	public LazyEmpInsertPerson(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmpInfo> translateRecordInfosHook(List<EmpInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<EmpInfo> getInstanceOfActionHook(DeciTreeOption<EmpInfo> option) {
		return new StdEmpInsertPerson(option);
	}
	
	
	
	@Override protected DeciResult<EmpInfo> translateResultHook(DeciResult<EmpInfo> result) {
		return result;
	}
}
