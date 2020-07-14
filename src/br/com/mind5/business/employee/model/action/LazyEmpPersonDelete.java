package br.com.mind5.business.employee.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmpPersonDelete extends ActionLazyTemplateV2<EmpInfo, EmpInfo> {
	
	public LazyEmpPersonDelete(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmpInfo> translateRecordInfosHook(List<EmpInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<EmpInfo> getInstanceOfActionHook(DeciTreeOption<EmpInfo> option) {
		return new StdEmpPersonDelete(option);
	}
	
	
	
	@Override protected DeciResult<EmpInfo> translateResultHook(DeciResult<EmpInfo> result) {
		return result;
	}
}
