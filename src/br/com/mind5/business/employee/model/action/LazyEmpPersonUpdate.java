package br.com.mind5.business.employee.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmpPersonUpdate extends ActionLazyTemplate<EmpInfo, EmpInfo> {
	
	public LazyEmpPersonUpdate(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmpInfo> translateRecordInfosHook(List<EmpInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<EmpInfo> getInstanceOfActionHook(DeciTreeOption<EmpInfo> option) {
		return new StdEmpPersonUpdate(option);
	}
	
	
	
	@Override protected DeciResult<EmpInfo> translateResultHook(DeciResult<EmpInfo> result) {
		return result;
	}
}
