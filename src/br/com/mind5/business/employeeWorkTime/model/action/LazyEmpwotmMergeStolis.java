package br.com.mind5.business.employeeWorkTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmpwotmMergeStolis extends ActionLazyTemplate<EmpwotmInfo, EmpwotmInfo> {
	
	public LazyEmpwotmMergeStolis(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmpwotmInfo> translateRecordInfosHook(List<EmpwotmInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<EmpwotmInfo> getInstanceOfActionHook(DeciTreeOption<EmpwotmInfo> option) {
		return new StdEmpwotmMergeStolis(option);
	}
	
	
	
	@Override protected DeciResult<EmpwotmInfo> translateResultHook(DeciResult<EmpwotmInfo> result) {
		return result;
	}
}
