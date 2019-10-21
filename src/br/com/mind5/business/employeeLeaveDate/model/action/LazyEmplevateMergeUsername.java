package br.com.mind5.business.employeeLeaveDate.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmplevateMergeUsername extends ActionLazyTemplate<EmplevateInfo, EmplevateInfo> {
	
	public LazyEmplevateMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmplevateInfo> translateRecordInfosHook(List<EmplevateInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<EmplevateInfo> getInstanceOfActionHook(DeciTreeOption<EmplevateInfo> option) {
		return new StdEmplevateMergeUsername(option);
	}
	
	
	
	@Override protected DeciResult<EmplevateInfo> translateResultHook(DeciResult<EmplevateInfo> result) {
		return result;
	}
}
