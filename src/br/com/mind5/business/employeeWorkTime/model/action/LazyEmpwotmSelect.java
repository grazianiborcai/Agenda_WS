package br.com.mind5.business.employeeWorkTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmpwotmSelect extends ActionLazyTemplateV1<EmpwotmInfo, EmpwotmInfo> {
	
	public LazyEmpwotmSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmpwotmInfo> translateRecordInfosHook(List<EmpwotmInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<EmpwotmInfo> getInstanceOfActionHook(DeciTreeOption<EmpwotmInfo> option) {
		return new StdEmpwotmSelect(option);
	}
	
	
	
	@Override protected DeciResult<EmpwotmInfo> translateResultHook(DeciResult<EmpwotmInfo> result) {
		return result;
	}
}
